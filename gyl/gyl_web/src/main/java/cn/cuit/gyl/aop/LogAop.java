package cn.cuit.gyl.aop;

import cn.cuit.gyl.controller.system.SysLogController;
import cn.cuit.gyl.domain.system.SysLog;
import cn.cuit.gyl.service.system.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

//该类用于给所有的Controller配置aop，记录访问信息
@Aspect
@Component
public class LogAop {

    @Autowired
    private HttpServletRequest request = null;

    @Autowired
    @Qualifier("sysLogServiceImpl")
    private ISysLogService iSysLogService = null;

    private Date visitTime; //开始时间
    private Class clazz; //访问的类
    private Method method;//访问的方法

    //执行controller方法前执行
    @Before("execution(* cn.cuit.gyl.controller.*.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        visitTime = new Date();//当前时间就是开始访问的时间
        clazz = joinPoint.getTarget().getClass(); //具体要访问的类
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();//获取访问的方法的名称
        Object[] args = joinPoint.getArgs();//获取访问的方法的参数
        /**
         * 新加一个给功能：当访问如：日志方法的findAllBySysLogOrTime类型时候，由于args中有null值，下面classArgs[i] = args[i].getClass()要报错
         * 解决办法：逐个排除
         */
        /*System.out.println(clazz.getSimpleName());
        System.out.println(methodName);*/
        /*if(methodName.equals("findAllBySysLogOrTime") && "SysLogController".equals(clazz.getSimpleName())){//排除日志方法findAllBySysLogOrTime方法
            method = clazz.getMethod("findAllBySysLogOrTime",SysLog.class,Date.class,Date.class,HttpServletRequest.class,Integer.class,Integer.class);
        }else {*/
            //获取具体执行的方法的Method对象
            if (args == null || args.length == 0) {
                method = clazz.getDeclaredMethod(methodName); //获取无参数的方法
            } else {
                Class[] classArgs = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    //System.out.println(args[i].toString());
                    if(args[i] instanceof ServletRequest){//由于security框架包装了HttpServletRequest，类型变了，所以找不到HttpServletRequest
                        classArgs[i] = HttpServletRequest.class;
                    }else if(args[i] instanceof ServletResponse){//由于security框架包装了HttpServletResponse，类型变了，所以找不到HttpServletRequest
                        classArgs[i] = HttpServletResponse.class;
                    }else {
                        classArgs[i] = args[i].getClass();
                    }
                    //System.out.println(classArgs[i]);
                }
                method = clazz.getDeclaredMethod(methodName,classArgs);
            }
        /*}*/
    }

    //执行controller方法后执行
    @After("execution(* cn.cuit.gyl.controller.*.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        //获取注解RequestMapping的值
        long time = new Date().getTime() - visitTime.getTime(); //获取访问的时长
        String url = "";
        //获取url
        if (clazz != null && method != null && clazz != LogAop.class) {
            //1.获取类上的@RequestMapping("/xxx")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                    //获取访问的ip
                    String ip = request.getRemoteAddr();
                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获了当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecution_time(time);//执行时长
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]" + clazz.getSimpleName() + "[方法名]" + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisit_time(visitTime);
                    //System.out.println(sysLog);
                    //调用Service完成操作
                    iSysLogService.save(sysLog);
                }
            }
        }
    }
}
