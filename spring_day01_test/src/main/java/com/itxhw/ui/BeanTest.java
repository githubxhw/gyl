package com.itxhw.ui;

import com.itxhw.dao.IAccountDao;
import com.itxhw.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 此类用于模拟表现层功能
 */
public class BeanTest {

    public static void main(String[] args) {
        /*使用类路径来获取配置文件*/
        /*
        * BeanFactory--》延迟加载 和 ApplicationContext---》立即加载
        * */
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        /*使用系统文件路径来获取配置文件*/
        /*ApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:\\ideal_workspace\\spring_day01_test\\src\\main\\resources\\bean.xml");
        IAccountService iAccountService1 = (IAccountService)applicationContext.getBean("IAccountService");
        IAccountService iAccountService2 = (IAccountService)applicationContext.getBean("IAccountService");
        iAccountService1.findAll();
        System.out.println(iAccountService1 == iAccountService2);*/

        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao dao1 = (IAccountDao)applicationContext.getBean("iAccountDaoInstance");
        IAccountDao dao2 = (IAccountDao)applicationContext.getBean("iAccountDaoStatic");
        dao1.findAll();
        dao2.findAll();*/

        /*下面测试依赖注入：Dependency Injection*/
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService iAccountService = (IAccountService)applicationContext.getBean("iAccountService");
        System.out.println(iAccountService.toString());*/

        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService iAccountService = (IAccountService)applicationContext.getBean("iAccountService");
        System.out.println(iAccountService.toString());*/


    }
}
