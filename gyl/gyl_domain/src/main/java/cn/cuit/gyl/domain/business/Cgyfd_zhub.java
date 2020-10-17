package cn.cuit.gyl.domain.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * (Cgyfd_zhub)实体类
 *
 * @author makejava
 * @since 2020-06-09 20:30:22
 */
public class Cgyfd_zhub implements Serializable {
    /**
    * 采购应付单主表id
    */
    private Integer cgyfd_zhu_id;
    /**
    * 单据号
    */
    private String djh;
    /**
    * 公司
    */
    private String gs;

    /**
    * 日期
    */
    private Date rq;
    /**
    * 起算日期：和财务有关
    */
    private Date qsrq;
    /**
    * 客商：客户，供应商
    */
    private String ks;
    /**
    * 部门
    */
    private String bm;
    /**
    * 业务员
    */
    private String ywy;
    /**
    * 生效标志：该表单是否生效
    */
    private Integer sxbz;
    /**
    * 制单人
    */
    private String zdr;
    /**
    * 制单时间

    */
    private Date zdsj;
    /**
    * 审批人
    */
    private String spr;
    /**
    * 审批时间
    */
    private Date spsj;
    /**
    * 签字人
    */
    private String qzr;
    /**
    * 签字时间
    */
    private Date qzsj;
    /**
    * 修改人
    */
    private String xgr;
    /**
    * 修改时间
    */
    private Date xgsj;
    /**
     * 修改时间
     */
    private Integer status;
    /**
     * 子表
     */
    private ArrayList<Cgyfd_zib> cgyfd_zibs;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getCgyfd_zhu_id() {
        return cgyfd_zhu_id;
    }

    public void setCgyfd_zhu_id(Integer cgyfd_zhu_id) {
        this.cgyfd_zhu_id = cgyfd_zhu_id;
    }

    public ArrayList<Cgyfd_zib> getCgyfd_zibs() {
        return cgyfd_zibs;
    }

    public void setCgyfd_zibs(ArrayList<Cgyfd_zib> cgyfd_zibs) {
        this.cgyfd_zibs = cgyfd_zibs;
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    public String getGs() {
        return gs;
    }

    public void setGs(String gs) {
        this.gs = gs;
    }

    public Date getRq() {
        return rq;
    }

    public void setRq(Date rq) {
        this.rq = rq;
    }

    public Date getQsrq() {
        return qsrq;
    }

    public void setQsrq(Date qsrq) {
        this.qsrq = qsrq;
    }

    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public Integer getSxbz() {
        return sxbz;
    }

    public void setSxbz(Integer sxbz) {
        this.sxbz = sxbz;
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
        this.zdsj = zdsj;
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
        this.spsj = spsj;
    }

    public String getQzr() {
        return qzr;
    }

    public void setQzr(String qzr) {
        this.qzr = qzr;
    }

    public Date getQzsj() {
        return qzsj;
    }

    public void setQzsj(Date qzsj) {
        this.qzsj = qzsj;
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
        this.xgsj = xgsj;
    }


    @Override
    public String toString() {
        return "Cgyfd_zhub{" +
                "cgyfd_zhu_id=" + cgyfd_zhu_id +
                ", djh='" + djh + '\'' +
                ", gs='" + gs + '\'' +
                ", rq=" + rq +
                ", qsrq=" + qsrq +
                ", ks='" + ks + '\'' +
                ", bm='" + bm + '\'' +
                ", ywy='" + ywy + '\'' +
                ", sxbz=" + sxbz +
                ", zdr='" + zdr + '\'' +
                ", zdsj=" + zdsj +
                ", spr='" + spr + '\'' +
                ", spsj=" + spsj +
                ", qzr='" + qzr + '\'' +
                ", qzsj=" + qzsj +
                ", xgr='" + xgr + '\'' +
                ", xgsj=" + xgsj +
                '}';
    }
}