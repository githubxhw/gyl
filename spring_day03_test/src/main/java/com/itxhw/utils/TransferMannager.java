package com.itxhw.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 提供事物控制方法
 */
/*@Component("transferMannger")
@Aspect*/

public class TransferMannager {

    ConnectionUtils connectionUtils = null;

    /*@Pointcut("execution(* com.itxhw.service.impl.*.*(..))")
    private void pt1(){
    }*/

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    //@Before("pt1()")
    public void startTransfer(){
        try {
            connectionUtils.getThreadLocalConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commitTransfer(){
        try {
            connectionUtils.getThreadLocalConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollbackTransfer(){
        try {
            connectionUtils.getThreadLocalConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    public void relase(){
        try {
            connectionUtils.getThreadLocalConnection().close();
            connectionUtils.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
