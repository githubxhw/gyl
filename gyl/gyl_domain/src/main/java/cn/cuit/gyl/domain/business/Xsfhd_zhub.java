package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.util.Date;
import java.util.List;

//销售发货单主表domain
public class Xsfhd_zhub {

    private Integer xsfhd_zhub_id;//销售发货单主表id
    private String ddh; //发货号
    private Date fhrq;//发货日期
    private String fhrqStr;
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
    private Integer sfckjs; //是否出库结束 1结束 0未结束 全部的商品都出库完毕才能设置为结束
    private String sfckjsStr;
    private Integer sfkpjs; //是否开票结束 1结束 0未结束 全部的商品都出库完毕才能设置为结束
    private String sfkpjsStr;
    private Integer status;//状态 1没有关闭 0关闭
    private String statusStr;

    //一对多
    private List<Xsfhd_zib> xsfhd_zibs;

    @Override
    public String toString() {
        return "Xsfhd_zhub{" +
                "xsfhd_zhub_id=" + xsfhd_zhub_id +
                ", ddh='" + ddh + '\'' +
                ", fhrq=" + fhrq +
                ", fhrqStr='" + fhrqStr + '\'' +
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
                ", sfckjs=" + sfckjs +
                ", sfckjsStr='" + sfckjsStr + '\'' +
                ", sfkpjs=" + sfkpjs +
                ", sfkpjsStr='" + sfkpjsStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", xsfhd_zibs=" + xsfhd_zibs +
                '}';
    }

    public Integer getSfkpjs() {
        return sfkpjs;
    }

    public void setSfkpjs(Integer sfkpjs) {
        if(sfkpjs != null){
            if(sfkpjs == 1){
                this.sfkpjsStr = "是";
            }else {
                this.sfkpjsStr = "否";
            }
        }
        this.sfkpjs = sfkpjs;
    }

    public String getSfkpjsStr() {
        return sfkpjsStr;
    }

    public void setSfkpjsStr(String sfkpjsStr) {
        this.sfkpjsStr = sfkpjsStr;
    }

    public Integer getSfckjs() {
        return sfckjs;
    }

    public void setSfckjs(Integer sfckjs) {
        if(sfckjs != null){
            if(sfckjs == 1){
                this.sfckjsStr = "是";
            }else {
                this.sfckjsStr = "否";
            }
        }
        this.sfckjs = sfckjs;
    }

    public String getSfckjsStr() {
        return sfckjsStr;
    }

    public void setSfckjsStr(String sfckjsStr) {
        this.sfckjsStr = sfckjsStr;
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

    public Integer getXsfhd_zhub_id() {
        return xsfhd_zhub_id;
    }

    public void setXsfhd_zhub_id(Integer xsfhd_zhub_id) {
        this.xsfhd_zhub_id = xsfhd_zhub_id;
    }

    public String getDdh() {
        return ddh;
    }

    public void setDdh(String ddh) {
        this.ddh = ddh;
    }

    public Date getFhrq() {
        return fhrq;
    }

    public void setFhrq(Date fhrq) {
        if(fhrq != null){
            this.fhrqStr = ConverterUtils.dateToString(fhrq, "yyyy-MM-dd HH:mm");
        }
        this.fhrq = fhrq;
    }

    public String getFhrqStr() {
        return fhrqStr;
    }

    public void setFhrqStr(String fhrqStr) {
        this.fhrqStr = fhrqStr;
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

    public List<Xsfhd_zib> getXsfhd_zibs() {
        return xsfhd_zibs;
    }

    public void setXsfhd_zibs(List<Xsfhd_zib> xsfhd_zibs) {
        this.xsfhd_zibs = xsfhd_zibs;
    }
}
