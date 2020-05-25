package com.itxhw.service;

import com.itxhw.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) /*该注解指示：替换原来的运行器*/
@ContextConfiguration(classes = {config.MainConfig.class}) /*指定 spring 配置文件的位置*/
public class TestUserService {

    @Autowired
    private IUserService dao = null;

    /**
     * 查询所有用户
     * @return
     */
    @Test
    public void testFindAll(){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.MainConfig.class);
        //IUserService dao = (IUserService) applicationContext.getBean("userServiceImpl");
        List<User> users;
        try {
            users = dao.findAll();
            for (User user:users) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据用户uid查询该用户信息
     * @return
     */
    @Test
    public void testFindOneById(){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.MainConfig.class);
        //IUserService dao = (IUserService) applicationContext.getBean("userServiceImpl");
        User user;
        try {
            user = dao.findOneById(41);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入一个用户信息
     */
    @Test
    public void testInsertUser(){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.MainConfig.class);
        //IUserService dao = (IUserService) applicationContext.getBean("userServiceImpl");
        User user = new User();
        user.setId(49);
        user.setUsername("insert");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("雅安");
        try {
            dao.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据用户uid删除该用户信息
     */
    @Test
    public void testDeleteUserById(){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.MainConfig.class);
        //IUserService dao = (IUserService) applicationContext.getBean("userServiceImpl");
        try {
            dao.deleteUserById(49);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据uid更新用户信息
     */
    @Test
    public void testUpdateUser() {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.MainConfig.class);
        //IUserService dao = (IUserService) applicationContext.getBean("userServiceImpl");
        User user = new User();
        user.setId(46);
        user.setUsername("陈吉山");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("西安");
        try {
            dao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
