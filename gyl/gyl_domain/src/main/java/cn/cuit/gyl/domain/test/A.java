package cn.cuit.gyl.domain.test;

import java.util.List;

public class A {

    private Integer a;
    private List<B> bList;

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", bList=" + bList +
                '}';
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public List<B> getbList() {
        return bList;
    }

    public void setbList(List<B> bList) {
        this.bList = bList;
    }

    public void reflect(BB c){
        System.out.println(a);
    }

}
