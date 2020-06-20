package cn.cuit.gyl.domain.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = { "handler" })
public class Xsysdzhub implements Serializable {
    private Long xsysdzhubid;//主键
    private String ddh;
    private String gs;
    private Date rq;//日期  销售应收单的出单日期
    private Date qsrq;//起算日期   从这个日期开始计算
    private String ks;//客商
    private String bm;//部门
    private String ywy;//业务员
    private Integer sxbz;//生效标志 0为没生效，1位生效
    private String zdr;//制单人
    private Date zdrq;//制单日期
    private String sher;//审核人
    private Date shrq;//审核日期
    private String qzr;//签字人
    private Date qzrq;//签字日期
    private String xgr;//修改人
    private Date xgrq;//修改日期

    private List<Xsysdzhib> xsysdzhibs;

    public String getDdh() {
        return ddh;
    }
    public void setDdh(String ddh) {
        this.ddh = ddh;
    }
    public List<Xsysdzhib> getXsysdzhibs() {
        return xsysdzhibs;
    }
    public void setXsysdzhibs(List<Xsysdzhib> xsysdzhibs) {
        this.xsysdzhibs = xsysdzhibs;
    }
    public Long getXsysdzhubid() {
        return xsysdzhubid;
    }
    public void setXsysdzhubid(Long xsysdzhubid) {
        this.xsysdzhubid = xsysdzhubid;
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
    public Date getZdrq() {
        return zdrq;
    }
    public void setZdrq(Date zdrq) {
        this.zdrq = zdrq;
    }
    public String getSher() {
        return sher;
    }
    public void setSher(String sher) {
        this.sher = sher;
    }
    public Date getShrq() {
        return shrq;
    }
    public void setShrq(Date shrq) {
        this.shrq = shrq;
    }
    public String getQzr() {
        return qzr;
    }
    public void setQzr(String qzr) {
        this.qzr = qzr;
    }
    public Date getQzrq() {
        return qzrq;
    }
    public void setQzrq(Date qzrq) {
        this.qzrq = qzrq;
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

    @Override
    public String toString() {
        return "Xsysdzhub{" +
                "xsysdzhubid=" + xsysdzhubid +
                ", ddh='" + ddh + '\'' +
                ", gs='" + gs + '\'' +
                ", rq=" + rq +
                ", qsrq=" + qsrq +
                ", ks='" + ks + '\'' +
                ", bm='" + bm + '\'' +
                ", ywy='" + ywy + '\'' +
                ", sxbz=" + sxbz +
                ", zdr='" + zdr + '\'' +
                ", zdrq=" + zdrq +
                ", shr='" + sher + '\'' +
                ", shrq=" + shrq +
                ", qzr='" + qzr + '\'' +
                ", qzrq=" + qzrq +
                ", xgr='" + xgr + '\'' +
                ", xgrq=" + xgrq +
                ", xsysdzhibs=" + xsysdzhibs +
                '}';
    }
}
