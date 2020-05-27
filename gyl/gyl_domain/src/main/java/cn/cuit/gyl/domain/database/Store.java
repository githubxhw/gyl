package cn.cuit.gyl.domain.database;

import java.io.Serializable;
import java.util.List;

//仓库实体类
public class Store implements Serializable {

    private Integer id;//仓库id
    private String storeNum;//仓库编码
    private String storeName;//仓库名称
    private String storeType;//仓库类型
    private String storeAddr;//仓库地址
    private Double storeSize;//仓库面积
    private Integer uid;//管理员id
    private String uname;//管理员名称
    private String uphone;//管理员电话

    List<Product> products;

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeNum='" + storeNum + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeType='" + storeType + '\'' +
                ", storeAddr=" + storeAddr +
                ", storeSize='" + storeSize + '\'' +
                ", uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uphone='" + uphone + '\'' +
                ", products=" + products +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }

    public Double getStoreSize() {
        return storeSize;
    }

    public void setStoreSize(Double storeSize) {
        this.storeSize = storeSize;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
