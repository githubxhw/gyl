package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.util.Date;

//销售出库预警表domain
public class EarlyWarning_Xsck {

    private Long id;//发货预警id
    private String ddh;//销售订单号（主表）
    private Integer hh;//行号（子表）
    private String productNum;//商品编码
    private String productName;//商品名称
    private Date yqfhrq;//要求发货日期
    private String yqfhrqStr;
    private Integer checkDays;//预警的天数：在要求发货日期的前checkDays内开始预警
    private Integer invalidDays;//预警失效天数：意思是如果要求发货日期到仍然没有发货，那么依然需要预警（即status状态为1），连续预警invalidDays后就不在预警了（即修改staus为0）；\r\n说明，没有值情况下默认不预警。
    private Integer status;//预警状态 是否需要预警 1是 0否

    @Override
    public String toString() {
        return "EarlyWarning_Xsck{" +
                "id=" + id +
                ", ddh='" + ddh + '\'' +
                ", hh=" + hh +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", yqfhrq=" + yqfhrq +
                ", yqfhrqStr=" + yqfhrqStr +
                ", checkDays=" + checkDays +
                ", invalidDays=" + invalidDays +
                ", status=" + status +
                '}';
    }

    public String getYqfhrqStr() {
        return yqfhrqStr;
    }

    public void setYqfhrqStr(String yqfhrqStr) {
        this.yqfhrqStr = yqfhrqStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdh() {
        return ddh;
    }

    public void setDdh(String ddh) {
        this.ddh = ddh;
    }

    public Integer getHh() {
        return hh;
    }

    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getYqfhrq() {
        return yqfhrq;
    }

    public void setYqfhrq(Date yqfhrq) {
        if(yqfhrq!=null){
            this.yqfhrqStr = ConverterUtils.dateToString(yqfhrq, "yyyy-MM-dd HH:mm");
        }
        this.yqfhrq = yqfhrq;
    }

    public Integer getCheckDays() {
        return checkDays;
    }

    public void setCheckDays(Integer checkDays) {
        this.checkDays = checkDays;
    }

    public Integer getInvalidDays() {
        return invalidDays;
    }

    public void setInvalidDays(Integer invalidDays) {
        this.invalidDays = invalidDays;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
