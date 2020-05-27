package cn.cuit.gyl.service.quartz.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        System.out.println("test");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/springmvc-test.xml");
    }
}
