package com.itxhw.factory;

import com.itxhw.dao.IAccountDao;
import com.itxhw.dao.IAccountImpl.AccountDaoImpl;

/**
 * 此工厂模拟jar类的类
 */
public class StaticFactory {

    public static IAccountDao getIAccountDao(){
        return new AccountDaoImpl();
    }
}
