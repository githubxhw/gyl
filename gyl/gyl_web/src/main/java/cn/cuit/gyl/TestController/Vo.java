package cn.cuit.gyl.TestController;

import java.util.Date;

public class Vo {

    private Integer a = 1;
    private String b = "xxx";
    private Date c = new Date();


    @Override
    public String toString() {
        return "Vo{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Date getC() {
        return c;
    }

    public void setC(Date c) {
        this.c = c;
    }
}
