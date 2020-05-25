package com.itxhw.dao.impl;

import com.itxhw.dao.IAccountDao;
import com.itxhw.domain.Account;
import com.itxhw.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AccountDaoImpl implements IAccountDao {

    QueryRunner queryRunner = null;

    ConnectionUtils connectionUtils = null;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public Account findAccountById(Integer id) throws SQLException {
        return queryRunner.query(connectionUtils.getThreadLocalConnection(),"select * from account where id = ?", new BeanHandler<Account>(Account.class),id);
    }

    public void updateAccount(Account account) throws SQLException {
        queryRunner.update(connectionUtils.getThreadLocalConnection(),"update account set money=? where id = ?",account.getMoney(),account.getId());
    }
}
