package com.itxhw.service.impl;

import com.itxhw.dao.IUserDao;
import com.itxhw.domain.User;
import com.itxhw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service(value = "userServiceImpl")
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao iUserDao = null;

    public void setiUserDao(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    public List<User> findAll() throws SQLException {
        return iUserDao.findAll();
    }

    public User findOneById(Integer uid) throws SQLException {
        return iUserDao.findOneById(uid);
    }

    public void insertUser(User user) throws SQLException {
        iUserDao.insertUser(user);
    }

    public void deleteUserById(Integer uid) throws SQLException {
        iUserDao.deleteUserById(uid);
    }

    public void updateUser(User user) throws SQLException {
        iUserDao.updateUser(user);
    }
}
