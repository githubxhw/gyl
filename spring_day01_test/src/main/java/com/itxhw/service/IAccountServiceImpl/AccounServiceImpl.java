package com.itxhw.service.IAccountServiceImpl;

import com.itxhw.service.IAccountService;

import java.util.Date;

public class AccounServiceImpl implements IAccountService {

    private Integer id;
    private String name;
    private Date birthday;

    public AccounServiceImpl(){
    }

    //有参构造函数
    public AccounServiceImpl(Integer id,String name,Date birthday){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void findAll() {
        System.out.println("AccounServiceImpl 执行了......");
    }

    @Override
    public String toString() {
        return "AccounServiceImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
