package com.itxhw.service.impl;

import com.itxhw.dao.IAccountDao;
import com.itxhw.domain.Account;
import com.itxhw.service.IAccountService;
import com.itxhw.utils.TransferMannager;

public class AccountServiceImpl implements IAccountService {

    IAccountDao dao = null;

    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

    public void transfer(Integer source, Integer dest, double money) throws Exception{
            //查询source账户
            Account sourceAccount = dao.findAccountById(source);
            //查询dest账户
            Account destAccount = dao.findAccountById(dest);
            //source账户减钱
            sourceAccount.setMoney(sourceAccount.getMoney()-money);
            //dest账户加钱
            destAccount.setMoney(destAccount.getMoney()+money);
            //修改source账户信息
            dao.updateAccount(sourceAccount);
            /*int i = 1/0;*/
            //修改dest账户信息
            dao.updateAccount(destAccount);
    }
}
