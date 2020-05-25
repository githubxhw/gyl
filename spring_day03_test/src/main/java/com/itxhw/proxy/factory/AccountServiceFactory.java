package com.itxhw.proxy.factory;

import com.itxhw.service.IAccountService;
import com.itxhw.utils.TransferMannager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于生产代理IAccountService
 */
public class AccountServiceFactory {

    IAccountService iAccountService = null;

    TransferMannager transferMannager = null;

    public void setiAccountService(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }

    public void setTransferMannager(TransferMannager transferMannager) {
        this.transferMannager = transferMannager;
    }

    public IAccountService getiAccountService(){
        return (IAccountService) Proxy.newProxyInstance(iAccountService.getClass().getClassLoader(), iAccountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*if("test".equals(method.getName())){
                    return method.invoke(iAccountService,args);
                }*/
                Object rtValue = null;
                try {
                    //1.开启事务
                    transferMannager.startTransfer();
                    //2.执行操作
                    rtValue = method.invoke(iAccountService, args);
                    //3.提交事务
                    transferMannager.commitTransfer();
                    //4.返回结果
                    return rtValue;
                } catch (Exception e) {
                    //5.回滚操作
                    transferMannager.rollbackTransfer();
                    throw new RuntimeException(e);
                } finally {
                    //6.释放连接
                    transferMannager.relase();
                }
            }
        });
    }
}
