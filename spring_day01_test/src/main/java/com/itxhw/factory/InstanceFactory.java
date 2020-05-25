package com.itxhw.factory;


import com.itxhw.dao.IAccountDao;
import com.itxhw.dao.IAccountImpl.AccountDaoImpl;

/**
 * 此工厂模拟jar类的类
 */
public class InstanceFactory {

    /**
     * 普通方法
     * @return
     */
    public IAccountDao getIAccountDao() {
        return new AccountDaoImpl();
    }
}
