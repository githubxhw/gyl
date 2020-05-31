package cn.cuit.gyl.domain.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = { "handler" })
public class PanDian implements Serializable {
    private Long id;//主表的id
    private String gs;//公司
    private String djh;//单据号
    private Date pdrq;//盘点日期
    private String ck;//仓库
    private String kcy;//库存员
    private String bm;//部门
    private String pdr;//盘点人
    private Integer status;//单据状态  1是审批 2是不审批
    private Date zdrq;//制单日期
    private String zdr;//制单人
    private String spr;//审批人
    private Date sprq;//审批日期
    private String tzr;//调整人（只能修改数量）
    private Date tzrq;//调整日期
    private String xgr;//修改人（可以修改所有的字段）
    private Date xgrq;//修改日期

    private List<PanDianZi> panDianZis;//子表的信息

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGs() {
        return gs;
    }

    public void setGs(String gs) {
        this.gs = gs;
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    public Date getPdrq() {
        return pdrq;
    }

    public void setPdrq(Date pdrq) {
        this.pdrq = pdrq;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public String getKcy() {
        return kcy;
    }

    public void setKcy(String kcy) {
        this.kcy = kcy;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getPdr() {
        return pdr;
    }

    public void setPdr(String pdr) {
        this.pdr = pdr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getZdrq() {
        return zdrq;
    }

    public void setZdrq(Date zdrq) {
        this.zdrq = zdrq;
    }

    public String getZdr() {
        return zdr;
    }

    public void setZdr(String zdr) {
        this.zdr = zdr;
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
        this.sprq = sprq;
    }

    public String getTzr() {
        return tzr;
    }

    public void setTzr(String tzr) {
        this.tzr = tzr;
    }

    public Date getTzrq() {
        return tzrq;
    }

    public void setTzrq(Date tzrq) {
        this.tzrq = tzrq;
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
        this.xgrq = xgrq;
    }

    public List<PanDianZi> getPanDianZis() {
        return panDianZis;
    }

    public void setPanDianZis(List<PanDianZi> panDianZis) {
        this.panDianZis = panDianZis;
    }

    @Override
    public String toString() {
        return "PanDian{" +
                "id=" + id +
                ", gs='" + gs + '\'' +
                ", djh='" + djh + '\'' +
                ", pdrq=" + pdrq +
                ", ck='" + ck + '\'' +
                ", kcy='" + kcy + '\'' +
                ", bm='" + bm + '\'' +
                ", pdr='" + pdr + '\'' +
                ", status=" + status +
                ", zdrq=" + zdrq +
                ", zdr='" + zdr + '\'' +
                ", spr='" + spr + '\'' +
                ", sprq=" + sprq +
                ", tzr='" + tzr + '\'' +
                ", tzrq=" + tzrq +
                ", xgr='" + xgr + '\'' +
                ", xgrq=" + xgrq +
                '}';
    }
}
