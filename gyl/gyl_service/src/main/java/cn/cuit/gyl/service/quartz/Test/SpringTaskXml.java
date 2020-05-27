package cn.cuit.gyl.service.quartz.Test;

import java.util.Date;

/**
 * 基于xml的定时器
 */
public class SpringTaskXml {

    public void show(){
        System.out.println(new Date() + " : XMl is show run");
    }

    public void print(){
        System.out.println(new Date() + " : XMl print run");
    }
}
