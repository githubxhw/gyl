package com.itxhw.dao;

import com.itxhw.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll() throws SQLException;

    /**
     * 根据用户uid查询该用户信息
     * @param uid
     * @return
     */
    public User findOneById(Integer uid) throws SQLException;

    /**
     * 插入一个用户信息
     * @param user
     */
    public void insertUser(User user)throws SQLException;

    /**
     * 根据用户uid删除该用户信息
     * @param uid
     */
    public void deleteUserById(Integer uid)throws SQLException;

    /**
     * 根据uid更新用户信息
     * @param user
     */
    public void updateUser(User user)throws SQLException;
}
