package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//销售预订单主表
public class Xsydd_zhub implements Serializable {

    private Integer xsydd_zhub_id; //销售预订单主表id
    private String ddh; //预订单号
    private Date dhrq; //定货日期
    private String dhrqStr;
    private String khmc;//客户名称
    private String xsbm;//销售部门
    private String ywy;//业务员
    private String spr;//审批人
    private Date sprq;//审批日期
    private String sprqStr;
    private String zdr;//制单人
    private Date zdrq;//制单日期
    private String zdrqStr;
    private String xgr;//修改人
    private Date xgrq;//修改日期
    private String xgrqStr;
    private Integer status = 0;//状态，1表示结束，0表示未结束
    private String statusStr;

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    //多表
    private List<Xsydd_zib> xsydd_zibs;

    @Override
    public String toString() {
        return "Xsydd_zhub{" +
                "xsydd_zhub_id=" + xsydd_zhub_id +
                ", ddh='" + ddh + '\'' +
                ", dhrq=" + dhrq +
                ", dhrqStr='" + dhrqStr + '\'' +
                ", khmc='" + khmc + '\'' +
                ", xsbm='" + xsbm + '\'' +
                ", ywy='" + ywy + '\'' +
                ", spr='" + spr + '\'' +
                ", sprq=" + sprq +
                ", sprqStr='" + sprqStr + '\'' +
                ", zdr='" + zdr + '\'' +
                ", zdrq=" + zdrq +
                ", zdrqStr='" + zdrqStr + '\'' +
                ", xgr='" + xgr + '\'' +
                ", xgrq=" + xgrq +
                ", xgrqStr='" + xgrqStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", xsydd_zibs=" + xsydd_zibs +
                '}';
    }

    public Integer getXsydd_zhub_id() {
        return xsydd_zhub_id;
    }

    public void setXsydd_zhub_id(Integer xsydd_zhub_id) {
        this.xsydd_zhub_id = xsydd_zhub_id;
    }

    public String getDdh() {
        return ddh;
    }

    public void setDdh(String ddh) {
        this.ddh = ddh;
    }

    public Date getDhrq() {
        return dhrq;
    }

    public void setDhrq(Date dhrq) {
        if(dhrq != null){
            this.dhrqStr = ConverterUtils.dateToString(dhrq, "yyyy-MM-dd HH:mm");
        }
        this.dhrq = dhrq;
    }

    public String getDhrqStr() {
        return dhrqStr;
    }

    public void setDhrqStr(String dhrqStr) {
        this.dhrqStr = dhrqStr;
    }

    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc;
    }

    public String getXsbm() {
        return xsbm;
    }

    public void setXsbm(String xsbm) {
        this.xsbm = xsbm;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public String getSpr() {
        return spr;
    }

    public void setSpr(String spr) {
        this.spr = spr;
    }

    public Date getSprq() {
        return sprq;
    }

    public void setSprq(Date sprq) {
        if(sprq != null){
            this.sprqStr = ConverterUtils.dateToString(sprq, "yyyy-MM-dd HH:mm");
        }
        this.sprq = sprq;
    }

    public String getSprqStr() {
        return sprqStr;
    }

    public void setSprqStr(String sprqStr) {
        this.sprqStr = sprqStr;
    }

    public String getZdr() {
        return zdr;
    }

    public void setZdr(String zdr) {
        this.zdr = zdr;
    }

    public Date getZdrq() {
        return zdrq;
    }

    public void setZdrq(Date zdrq) {
        if(zdrq != null){
            this.zdrqStr = ConverterUtils.dateToString(zdrq, "yyyy-MM-dd HH:mm");
        }
        this.zdrq = zdrq;
    }

    public String getZdrqStr() {
        return zdrqStr;
    }

    public void setZdrqStr(String zdrqStr) {
        this.zdrqStr = zdrqStr;
    }

    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    public Date getXgrq() {
        return xgrq;
    }

    public void setXgrq(Date xgrq) {
        if(xgrq != null){
            this.xgrqStr = ConverterUtils.dateToString(xgrq, "yyyy-MM-dd HH:mm");
        }
        this.xgrq = xgrq;
    }

    public String getXgrqStr() {
        return xgrqStr;
    }

    public void setXgrqStr(String xgrqStr) {
        this.xgrqStr = xgrqStr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        if(status != null){
            if(status == 1){
                statusStr = "结束";
            }else {
                statusStr = "未结束";
            }
        }
        this.status = status;
    }

    public List<Xsydd_zib> getXsydd_zibs() {
        return xsydd_zibs;
    }

    public void setXsydd_zibs(List<Xsydd_zib> xsydd_zibs) {
        this.xsydd_zibs = xsydd_zibs;
    }
}
