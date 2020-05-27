package cn.cuit.gyl.controller.system;

import cn.cuit.gyl.domain.system.SysLog;
import cn.cuit.gyl.service.system.ISysLogService;
import cn.cuit.gyl.utils.ConverterUtils;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.objects.XNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller("sysLogController")
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    @Qualifier("sysLogServiceImpl")
    private ISysLogService service = null;

    //查询当天的日志 6条数据 /*@RequestParam(name = "sysLog",required = false) SysLog sysLog, @RequestParam(name = "startTime",required = false) Date startTime, @RequestParam(name = "endTime",required = false) Date endTime,*/
    @RequestMapping("/findAllBySysLogOrTime")
    public String findAllBySysLogOrTime(HttpServletRequest request, @RequestParam(name="pageNum",required=true,defaultValue="1") Integer pageNum, @RequestParam(name="pageSize",required=true,defaultValue="10") Integer pageSize) throws Exception{
        List<SysLog> sysLogs = null;
        SysLog sysLog = null;
        Date startTime = null;
        Date endTime = null;
        String queryMethod = request.getParameter("queryMethod");//判断是什么方式查询
        /*System.out.println(queryMethod);*/
        //ContectQuery TimePeriodQuery
        if("ContectQuery".equals(queryMethod)){
            String execution_time = request.getParameter("execution_time");
            sysLog = new SysLog();
            sysLog.setUsername(request.getParameter("username"));
            sysLog.setIp(request.getParameter("ip"));
            sysLog.setUrl(request.getParameter("url"));
            sysLog.setMethod(request.getParameter("method"));
            if(!"".equals(execution_time) && execution_time!=null){
                sysLog.setExecution_time(Long.parseLong(execution_time));
            }
            sysLogs = service.findAllBySysLogOrTime(sysLog,startTime,endTime,pageNum,pageSize);
        }else if("TimePeriodQuery".equals(queryMethod)) {
            String startTimeStr = request.getParameter("startTime");
            String endTimeStr = request.getParameter("endTime");
            startTime = ConverterUtils.stringToDate(startTimeStr, "yyyy-MM-dd HH:mm");
            endTime = ConverterUtils.stringToDate(endTimeStr, "yyyy-MM-dd HH:mm");
            sysLogs = service.findAllBySysLogOrTime(sysLog,startTime,endTime,pageNum,pageSize);
        }else {
            System.out.println("queryMethod参数不符！");
        }
        /*if(sysLogs!=null){
            for (SysLog sysLog1:sysLogs) {
                System.out.println(sysLog1);
            }
        }*/
        PageInfo pageInfo = new PageInfo(sysLogs);
        if(sysLog!=null){
            /*System.out.println(sysLog);*/
            request.setAttribute("log", sysLog);
        }
        if(startTime != null && endTime != null){
            /*System.out.println(ConverterUtils.dateToString(startTime,"yyyy-MM-dd HH:mm"));
            System.out.println(ConverterUtils.dateToString(endTime,"yyyy-MM-dd HH:mm"));*/
            request.setAttribute("startTimeStr", ConverterUtils.dateToString(startTime,"yyyy-MM-dd HH:mm"));
            request.setAttribute("endTimeStr",ConverterUtils.dateToString(endTime,"yyyy-MM-dd HH:mm"));
        }
        request.setAttribute("queryMethod", queryMethod);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/system/syslog-list.jsp";
    }

    //根据id删除日志
    @RequestMapping("/deleteById")
    public String deleteById(Long id) throws Exception{
        service.deleteById(id);
        return "redirect:/sysLog/findAllBySysLogOrTime?queryMethod=TimePeriodQuery";
    }

    //根据多个id删除多条日志
    @RequestMapping("/deleteByIds")
    public String deleteByIds(Long[] ids) throws Exception{
        service.deleteByIds(ids);
        return "redirect:/sysLog/findAllBySysLogOrTime?queryMethod=TimePeriodQuery";
    }
}
