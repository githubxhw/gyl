package com.itxhw.service.IAccountServiceImpl;

import com.itxhw.service.IAccountService;

import java.util.*;

public class AccountServiceImp implements IAccountService {

    private String[] myStr;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public String[] getMyStr() {
        return myStr;
    }

    public void setMyStr(String[] myStr) {
        this.myStr = myStr;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public Set<String> getMySet() {
        return mySet;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public Properties getMyProps() {
        return myProps;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public String toString() {
        return "AccountServiceImp{" +"\n"+
                "myStr=" + Arrays.toString(myStr) +"\n"+
                ", myList=" + myList +"\n"+
                ", mySet=" + mySet +"\n"+
                ", myMap=" + myMap +"\n"+
                ", myProps=" + myProps +"\n"+
                '}';
    }

    @Override
    public void findAll() {
        System.out.println("AccountServiceImp 执行了...");
    }
}
