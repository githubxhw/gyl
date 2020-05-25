package com.itxhw.service;

public interface IAccountService {

    /**
     * 转账业务
     * @param source
     * @param dest
     * @param money
     */
    public void transfer(Integer source,Integer dest,double money) throws Exception;
}
