package cn.cuit.gyl.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 该类的使用说明：
 * 该类继承了接口ApplicationContextAware
 * 作用：可以获取ApplicationContext里面的bean，而不用二次加载spring-context.xml文件
 * 一共有4个常用的方法
 */
@Component /*一定要有这个注解*/
public class SpringUtils implements ApplicationContextAware {

    //上下文对象
    private static ApplicationContext applicationContext;

    //该方法会在使用web.xml加载spring文件创建bean后自动调用来获取上下文
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
        }
    }

    //方法1：获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //方法2：通过name获取 Bean
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    //方法3：通过class获取Bean
    public static Object getBean(Class clazz) {
        return applicationContext.getBean(clazz);
    }

    //方法4：通过name,以及Clazz返回指定的Bean
    public static Object getBean(String name, Class clazz) {
        return applicationContext.getBean(name, clazz);
    }


}
