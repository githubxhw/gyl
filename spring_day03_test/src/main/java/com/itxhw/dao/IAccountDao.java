package com.itxhw.dao;

import com.itxhw.domain.Account;

import java.sql.SQLException;

public interface IAccountDao {

    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    public Account findAccountById(Integer id) throws SQLException;

    /**
     * 更新账户信息
     * @param account
     */
    public void updateAccount(Account account) throws SQLException;
}
