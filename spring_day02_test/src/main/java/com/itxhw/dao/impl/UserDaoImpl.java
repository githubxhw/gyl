package com.itxhw.dao.impl;

import com.itxhw.dao.IUserDao;
import com.itxhw.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository(value = "userDaoImpl")
public class UserDaoImpl implements IUserDao {

    //@Resource()一步
    //@Qualifier()要与@Autowired连用

    @Autowired
    QueryRunner queryRunner = null;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<User> findAll() throws SQLException {
        return queryRunner.query("select * from user",new BeanListHandler<User>(User.class));
    }

    public User findOneById(Integer uid) throws SQLException{
        return queryRunner.query("select * from user where id = ?",new BeanHandler<User>(User.class),uid);
    }

    public void insertUser(User user)throws SQLException {
        queryRunner.update("insert into user values(?,?,?,?,?)",
                user.getId(),
                user.getUsername(),
                user.getBirthday(),
                user.getSex(),
                user.getAddress()
        );
    }

    public void deleteUserById(Integer uid)throws SQLException {
        queryRunner.update("delete from user where id = ?",uid);
    }

    public void updateUser(User user)throws SQLException {
        queryRunner.update("update user set username=?,sex=?,birthday=?,address=? where id = ?",
                user.getUsername(),
                user.getSex(),
                user.getBirthday(),
                user.getAddress(),
                user.getId()
        );
    }

    public static void main(String[] args) {

    }
}
