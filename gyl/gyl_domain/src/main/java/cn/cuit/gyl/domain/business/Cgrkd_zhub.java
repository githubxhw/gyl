package cn.cuit.gyl.domain.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Cgrkd_zhub)实体类
 *
 * @author makejava
 * @since 2020-05-09 18:42:34
 */
public class Cgrkd_zhub implements Serializable {

    /**
    * 采购入库单主表id
    */
    private Integer cgrkd_zhub_id;
    /**
    * 单据号
    */
    private String djh;
    /**
    * 单据日期
    */
    private Date djrq;
    /**
    * 仓库
    */
    private String ck;
    /**
    * 库管员
    */
    private String kgy;
    /**
    * 部门
    */
    private String bm;
    /**
    * 客户
    */
    private String kh;
    /**
    * 制单人
    */
    private String zdr;
    /**
    * 制单日期
    */
    private Date zdrq;
    /**
    * 审核人
    */
    private String spr;
    /**
    * 审核日期
    */
    private Date shrq;
    /**
    * 是否审核 1已审核 0未审核
    */
    private Integer sfsh;
    /**
    * 审核是否通过 1已通过 0未通过
    */
    private Integer shsftg;
    /**
    * 修改人
    */
    private String xgr;
    /**
    * 修改日期
    */
    private Date xgrq;
    /**
    * 是否退货 1有 0没有
    */
    private Integer sfth;
    /**
    * 单据状态 1开启 0关闭
    */
    private Integer status;
    /**
     * 子表
     */
    private List<Cgrkd_zib> cgrkd_zibs;

    @Override
    public String toString() {
        return "Cgrkd_zhub{" +
                "cgrkd_zhub_id=" + cgrkd_zhub_id +
                ", djh='" + djh + '\'' +
                ", djrq=" + djrq +
                ", ck='" + ck + '\'' +
                ", kgy='" + kgy + '\'' +
                ", bm='" + bm + '\'' +
                ", kh='" + kh + '\'' +
                ", zdr='" + zdr + '\'' +
                ", zdrq=" + zdrq +
                ", spr='" + spr + '\'' +
                ", shrq=" + shrq +
                ", sfsh=" + sfsh +
                ", shsftg=" + shsftg +
                ", xgr='" + xgr + '\'' +
                ", xgrq=" + xgrq +
                ", sfth=" + sfth +
                ", status=" + status +
                ", cgrkd_zibs=" + cgrkd_zibs +
                '}';
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
        this.djrq = djrq;
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
        this.zdrq = zdrq;
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
        this.shrq = shrq;
    }

    public Integer getSfsh() {
        return sfsh;
    }

    public void setSfsh(Integer sfsh) {
        this.sfsh = sfsh;
    }

    public Integer getShsftg() {
        return shsftg;
    }

    public void setShsftg(Integer shsftg) {
        this.shsftg = shsftg;
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

    public Integer getSfth() {
        return sfth;
    }

    public void setSfth(Integer sfth) {
        this.sfth = sfth;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCgrkd_zhub_id() {
        return cgrkd_zhub_id;
    }

    public void setCgrkd_zhub_id(Integer cgrkd_zhub_id) {
        this.cgrkd_zhub_id = cgrkd_zhub_id;
    }

    public List<Cgrkd_zib> getCgrkd_zibs() {
        return cgrkd_zibs;
    }

    public void setCgrkd_zibs(List<Cgrkd_zib> cgrkd_zibs) {
        this.cgrkd_zibs = cgrkd_zibs;
    }
}