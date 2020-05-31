package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.util.Date;
import java.util.List;

//采购到货单主表domain
public class Cgdhd_zhub {

    private Integer cgdhd_zhub_id;//采购到货单主表id
    private String ddh; //到货号
    private Date dhrq;//到货日期
    private String dhrqStr;
    private String ck;//仓库
    private String kgy;//库管员
    private String bm;//部门
    private String kh;//客户
    private String zdr;//制单人
    private Date zdsj;//制单时间
    private String zdsjStr;
    private String spr;//审批人
    private Date spsj;//审批时间
    private Integer sfsp;//是否审批 是否审批 1已经审批 0还没有审批
    private String sfspStr;
    private Integer spsftg;//审批是否通过 审批是否通过 1通过 0未通过
    private String spsftgStr;
    private String spsjStr;
    private String xgr;//修改人
    private Date xgsj;//修改时间
    private String xgsjStr;
    private Integer sfth;//是否退货 1退货 0没有退货
    private String sfthStr;
    private Integer sfrkjs; //是否入库结束 1结束 0未结束 全部的商品都出库完毕才能设置为结束
    private String sfrkjsStr;
    private Integer status;//状态 1没有关闭 0关闭
    private String statusStr;

    //一对多
    private List<Cgdhd_zib> cgdhd_zibs;

    @Override
    public String toString() {
        return "Cgdhd_zhub{" +
                "cgdhd_zhub_id=" + cgdhd_zhub_id +
                ", ddh='" + ddh + '\'' +
                ", dhrq=" + dhrq +
                ", dhrqStr='" + dhrqStr + '\'' +
                ", ck='" + ck + '\'' +
                ", kgy='" + kgy + '\'' +
                ", bm='" + bm + '\'' +
                ", kh='" + kh + '\'' +
                ", zdr='" + zdr + '\'' +
                ", zdsj=" + zdsj +
                ", zdsjStr='" + zdsjStr + '\'' +
                ", spr='" + spr + '\'' +
                ", spsj=" + spsj +
                ", sfsp=" + sfsp +
                ", sfspStr='" + sfspStr + '\'' +
                ", spsftg=" + spsftg +
                ", spsftgStr='" + spsftgStr + '\'' +
                ", spsjStr='" + spsjStr + '\'' +
                ", xgr='" + xgr + '\'' +
                ", xgsj=" + xgsj +
                ", xgsjStr='" + xgsjStr + '\'' +
                ", sfth=" + sfth +
                ", sfthStr='" + sfthStr + '\'' +
                ", sfrkjs=" + sfrkjs +
                ", sfrkjsStr='" + sfrkjsStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", cgdhd_zibs=" + cgdhd_zibs +
                '}';
    }

    public Integer getSfrkjs() {
        return sfrkjs;
    }

    public void setSfrkjs(Integer sfrkjs) {
        if(sfrkjs != null){
            if(sfrkjs == 1){
                this.sfrkjsStr = "结束";
            }else {
                this.sfrkjsStr = "未结束";
            }
        }
        this.sfrkjs = sfrkjs;
    }

    public String getSfrkjsStr() {
        return sfrkjsStr;
    }

    public void setSfrkjsStr(String sfrkjsStr) {
        this.sfrkjsStr = sfrkjsStr;
    }

    public Integer getSfsp() {
        return sfsp;
    }

    public void setSfsp(Integer sfsp) {
        if(sfsp != null){
            if(sfsp == 1){
                this.sfspStr = "是";
            }else {
                this.sfspStr = "否";
            }
        }
        this.sfsp = sfsp;
    }

    public String getSfspStr() {
        return sfspStr;
    }

    public void setSfspStr(String sfspStr) {
        this.sfspStr = sfspStr;
    }

    public Integer getSpsftg() {
        return spsftg;
    }

    public void setSpsftg(Integer spsftg) {
        if(spsftg != null){
            if(spsftg == 1){
                this.spsftgStr = "通过";
            }else {
                this.spsftgStr = "未通过";
            }
        }
        this.spsftg = spsftg;
    }

    public String getSpsftgStr() {
        return spsftgStr;
    }

    public void setSpsftgStr(String spsftgStr) {
        this.spsftgStr = spsftgStr;
    }

    public Integer getCgdhd_zhub_id() {
        return cgdhd_zhub_id;
    }

    public void setCgdhd_zhub_id(Integer cgdhd_zhub_id) {
        this.cgdhd_zhub_id = cgdhd_zhub_id;
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

    public Date getZdsj() {
        return zdsj;
    }

    public void setZdsj(Date zdsj) {
        if(zdsj != null){
            this.zdsjStr = ConverterUtils.dateToString(zdsj, "yyyy-MM-dd HH:mm");
        }
        this.zdsj = zdsj;
    }

    public String getZdsjStr() {
        return zdsjStr;
    }

    public void setZdsjStr(String zdsjStr) {
        this.zdsjStr = zdsjStr;
    }

    public String getSpr() {
        return spr;
    }

    public void setSpr(String spr) {
        this.spr = spr;
    }

    public Date getSpsj() {
        return spsj;
    }

    public void setSpsj(Date spsj) {
        if(spsj != null){
            this.spsjStr = ConverterUtils.dateToString(spsj, "yyyy-MM-dd HH:mm");
        }
        this.spsj = spsj;
    }

    public String getSpsjStr() {
        return spsjStr;
    }

    public void setSpsjStr(String spsjStr) {
        this.spsjStr = spsjStr;
    }

    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        if(xgsj != null){
            this.xgsjStr = ConverterUtils.dateToString(xgsj, "yyyy-MM-dd HH:mm");
        }
        this.xgsj = xgsj;
    }

    public String getXgsjStr() {
        return xgsjStr;
    }

    public void setXgsjStr(String xgsjStr) {
        this.xgsjStr = xgsjStr;
    }

    public Integer getSfth() {
        return sfth;
    }

    public void setSfth(Integer sfth) {
        if(sfth != null){
            if(sfth == 1){
                this.sfthStr = "退货";
            }else {
                this.sfthStr = "未退货";
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

    public List<Cgdhd_zib> getCgdhd_zibs() {
        return cgdhd_zibs;
    }

    public void setCgdhd_zibs(List<Cgdhd_zib> cgdhd_zibs) {
        this.cgdhd_zibs = cgdhd_zibs;
    }
}

