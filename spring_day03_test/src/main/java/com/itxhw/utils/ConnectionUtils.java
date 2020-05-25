package com.itxhw.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 该类用于获取当前线程绑定的Connection
 */
public class ConnectionUtils {

    ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    ComboPooledDataSource dataSource = null;

    public void setDataSource(ComboPooledDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取连接
     * @return
     */
    public Connection getThreadLocalConnection(){
        Connection con = threadLocal.get();
        if(con == null){
            try {
                //获取连接
                con = dataSource.getConnection();
                //绑定
                threadLocal.set(con);
            } catch (SQLException e) {
               throw new RuntimeException(e);
            }
        }
        return con;
    }

    /**
     * 解绑
     */
    public void remove(){
        threadLocal.remove();
    }

}
