package com.itxhw.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestAccountService {

    @Autowired
    @Qualifier("accountServiceImpl")
    IAccountService service = null;

    @Test
    public void TestTransfer(){
        try {
            service.transfer(1, 2, 50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
