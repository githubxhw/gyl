package cn.cuit.gyl.domain.database;

import cn.cuit.gyl.utils.ConverterUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//商品实体类
public class Product implements Serializable {

    private Long pid;//商品id
    private String pnum; //商品的编码         注意：商品编码规则是根据商品的表中的pid加工后得到的12位编码
    private String pname; //商品名称
    private String type; //商品型号
    private String unit;//商品单位
    private Double price;//商品单价
    private Float rate;//商品税率%
    private Date mfd;//商品生产日期
    private String mfdStr;
    private Date exp;//商品失效日期
    private String expStr;
    private String pdesc;//商品描述

    //多表
    List<Store> stores;

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pnum='" + pnum + '\'' +
                ", pname='" + pname + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", rate=" + rate +
                ", mfd=" + mfd +
                ", mfdStr='" + mfdStr + '\'' +
                ", exp=" + exp +
                ", expStr='" + expStr + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", stores=" + stores +
                '}';
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Date getMfd() {
        return mfd;
    }

    public void setMfd(Date mfd) {
        if (mfd != null) {
            this.mfdStr = ConverterUtils.dateToString(mfd, "yyyy-MM-dd HH:mm");
        }
        this.mfd = mfd;
    }

    public String getMfdStr() {
        return mfdStr;
    }

    public void setMfdStr(String mfdStr) {
        this.mfdStr = mfdStr;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        if (exp != null) {
            this.expStr = ConverterUtils.dateToString(exp, "yyyy-MM-dd HH:mm");
        }
        this.exp = exp;
    }

    public String getExpStr() {
        return expStr;
    }

    public void setExpStr(String expStr) {
        this.expStr = expStr;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
