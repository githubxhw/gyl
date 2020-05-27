package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//销售出库单主表domain 18 2700px
public class Xsckd_zhub implements Serializable {

    private Integer xsckd_zhub_id;//销售出库单主表id
    private String djh;//单据号
    private Date djrq;//出库日期
    private String djrqStr;
    private String ck;//仓库
    private String kgy;//库管员
    private String bm;//部门
    private String kh;//客户
    private String zdr;//制单人
    private Date zdrq;//制单日期
    private String zdrqStr;
    private String spr;//审核人
    private Date shrq;//审核日期
    private String shrqStr;
    private Integer sfsh;//是否审核 1已审核 0未审核
    private String sfshStr;
    private Integer shsftg;//审核是否通过 1已通过 0未通过
    private String shsftgStr;
    private String xgr;//修改人
    private Date xgrq;//修改日期
    private String xgrqStr;
    private Integer sfth;//是否退货 1有 0没有
    private String sfthStr;
    private Integer status;//单据状态 1开启 0关闭
    private String statusStr;

    //子表
    private List<Xsckd_zib> xsckd_zibs;

    @Override
    public String toString() {
        return "Xsckd_zhub{" +
                "xsckd_zhub_id=" + xsckd_zhub_id +
                ", djh='" + djh + '\'' +
                ", djrq=" + djrq +
                ", djrqStr='" + djrqStr + '\'' +
                ", ck='" + ck + '\'' +
                ", kgy='" + kgy + '\'' +
                ", bm='" + bm + '\'' +
                ", kh='" + kh + '\'' +
                ", zdr='" + zdr + '\'' +
                ", zdrq=" + zdrq +
                ", zdrqStr='" + zdrqStr + '\'' +
                ", spr='" + spr + '\'' +
                ", shrq=" + shrq +
                ", shrqStr='" + shrqStr + '\'' +
                ", sfsh=" + sfsh +
                ", sfshStr='" + sfshStr + '\'' +
                ", shsftg=" + shsftg +
                ", shsftgStr='" + shsftgStr + '\'' +
                ", xgr='" + xgr + '\'' +
                ", xgrq=" + xgrq +
                ", xgrqStr='" + xgrqStr + '\'' +
                ", sfth=" + sfth +
                ", sfthStr='" + sfthStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", xsckd_zibs=" + xsckd_zibs +
                '}';
    }

    public String getXgrqStr() {
        return xgrqStr;
    }

    public void setXgrqStr(String xgrqStr) {
        this.xgrqStr = xgrqStr;
    }

    public Integer getXsckd_zhub_id() {
        return xsckd_zhub_id;
    }

    public void setXsckd_zhub_id(Integer xsckd_zhub_id) {
        this.xsckd_zhub_id = xsckd_zhub_id;
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    public Date getDjrq() {
        return djrq;
    }

    public void setDjrq(Date djrq) {
        if(djrq != null){
            this.djrqStr = ConverterUtils.dateToString(djrq, "yyyy-MM-dd HH:mm");
        }
        this.djrq = djrq;
    }

    public String getDjrqStr() {
        return djrqStr;
    }

    public void setDjrqStr(String djrqStr) {
        this.djrqStr = djrqStr;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public String getKgy() {
        return kgy;
    }

    public void setKgy(String kgy) {
        this.kgy = kgy;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
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

    public String getSpr() {
        return spr;
    }

    public void setSpr(String spr) {
        this.spr = spr;
    }

    public Date getShrq() {
        return shrq;
    }

    public void setShrq(Date shrq) {
        if(shrq != null){
            this.shrqStr = ConverterUtils.dateToString(shrq, "yyyy-MM-dd HH:mm");
        }
        this.shrq = shrq;
    }

    public String getShrqStr() {
        return shrqStr;
    }

    public void setShrqStr(String shrqStr) {
        this.shrqStr = shrqStr;
    }

    public Integer getSfsh() {
        return sfsh;
    }

    public void setSfsh(Integer sfsh) {
        if(sfsh != null){
            if(sfsh == 1){
                this.sfshStr = "是";
            }else {
                this.sfshStr = "否";
            }
        }
        this.sfsh = sfsh;
    }

    public String getSfshStr() {
        return sfshStr;
    }

    public void setSfshStr(String sfshStr) {
        this.sfshStr = sfshStr;
    }

    public Integer getShsftg() {
        return shsftg;
    }

    public void setShsftg(Integer shsftg) {
        if(shsftg != null){
            if(shsftg == 1){
                this.shsftgStr = "是";
            }else {
                this.shsftgStr = "否";
            }
        }
        this.shsftg = shsftg;
    }

    public String getShsftgStr() {
        return shsftgStr;
    }

    public void setShsftgStr(String shsftgStr) {
        this.shsftgStr = shsftgStr;
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

    public Integer getSfth() {
        return sfth;
    }

    public void setSfth(Integer sfth) {
        if(sfth != null){
            if(sfth == 1){
                this.sfthStr = "是";
            }else {
                this.sfthStr = "否";
            }
        }
        this.sfth = sfth;
    }

    public String getSfthStr() {
        return sfthStr;
    }

    public void setSfthStr(String sfthStr) {
        this.sfthStr = sfthStr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        if(status != null){
            if(status == 1){
                this.statusStr = "结束";
            }else {
                this.statusStr = "未结束";
            }
        }
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Xsckd_zib> getXsckd_zibs() {
        return xsckd_zibs;
    }

    public void setXsckd_zibs(List<Xsckd_zib> xsckd_zibs) {
        this.xsckd_zibs = xsckd_zibs;
    }
}
