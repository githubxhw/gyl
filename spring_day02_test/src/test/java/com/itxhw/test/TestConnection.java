package com.itxhw.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {


    public static void main(String[] args) {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/xhw?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("xhw123");
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            //开启事务
            connection.setAutoCommit(false);
            //减少用户1的50元
            queryRunner.update(connection, "update account set money=money-50 where id = 1");
            //int i = 1/0;
            //增加用户2的50元
            queryRunner.update(connection,"update account set money=money+50 where id = 2");
            connection.commit();
        }catch (Exception e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
