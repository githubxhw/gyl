package cn.cuit.gyl.domain.business;

import java.io.Serializable;

public class Xsysdzhib implements Serializable {
    private Long xsysdzhibid;//主键
    private Long sl;//数量
    private Long hh;//行号
    private String spmc;//商品名称
    private String spbm;//商品编码
    private String dw;//单位
    private Float hsje;//含税金额
    private Float se;//税额
    private Float wsje;//无税金额
    private String lydjh;//来源单据号  发票号
    private Integer lyhh;//来源行号
    private String ytdjh;//源头单据号
    private Integer ythh;//源头行号
    private Float dj;//单价

    private Long ljyssl;//累计应收数量
    private Integer isysgb;//是否应收关闭 0为没关闭，1为关闭

    private Long zid;//主表的ID
    public Long getXsysdzhibid() {
        return xsysdzhibid;
    }

    public void setXsysdzhibid(Long xsysdzhibid) {
        this.xsysdzhibid = xsysdzhibid;
    }

    public Long getSl() {
        return sl;
    }

    public void setSl(Long sl) {
        this.sl = sl;
    }

    public Long getHh() {
        return hh;
    }

    public void setHh(Long hh) {
        this.hh = hh;
    }

    public Long getZid() {
        return zid;
    }

    public void setZid(Long zid) {
        this.zid = zid;
    }

    public String getSpmc() {
        return spmc;
    }

    public void setSpmc(String spmc) {
        this.spmc = spmc;
    }

    public String getSpbm() {
        return spbm;
    }

    public void setSpbm(String spbm) {
        this.spbm = spbm;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public Float getHsje() {
        return hsje;
    }

    public void setHsje(Float hsje) {
        this.hsje = hsje;
    }

    public Float getSe() {
        return se;
    }

    public void setSe(Float se) {
        this.se = se;
    }

    public Float getWsje() {
        return wsje;
    }

    public void setWsje(Float wsje) {
        this.wsje = wsje;
    }

    public String getLydjh() {
        return lydjh;
    }

    public void setLydjh(String lydjh) {
        this.lydjh = lydjh;
    }

    public Integer getLyhh() {
        return lyhh;
    }

    public void setLyhh(Integer lyhh) {
        this.lyhh = lyhh;
    }

    public String getYtdjh() {
        return ytdjh;
    }

    public void setYtdjh(String ytdjh) {
        this.ytdjh = ytdjh;
    }

    public Integer getYthh() {
        return ythh;
    }

    public void setYthh(Integer ythh) {
        this.ythh = ythh;
    }

    public Float getDj() {
        return dj;
    }

    public void setDj(Float dj) {
        this.dj = dj;
    }

    public Long getLjyssl() {
        return ljyssl;
    }

    public void setLjyssl(Long ljyssl) {
        this.ljyssl = ljyssl;
    }

    public Integer getIsysgb() {
        return isysgb;
    }

    public void setIsysgb(Integer isysgb) {
        this.isysgb = isysgb;
    }

    @Override
    public String toString() {
        return "Xsysdzhib{" +
                "xsysdzhibid=" + xsysdzhibid +
                ", zid="+zid+
                ", sl=" + sl +
                ", hh=" + hh +
                ", spmc='" + spmc + '\'' +
                ", spbm='" + spbm + '\'' +
                ", dw='" + dw + '\'' +
                ", hsje=" + hsje +
                ", se=" + se +
                ", wsje=" + wsje +
                ", lydjh='" + lydjh + '\'' +
                ", lyhh='" + lyhh + '\'' +
                ", ytdjh='" + ytdjh + '\'' +
                ", ythh=" + ythh +
                ", dj=" + dj +
                ", ljyssl=" + ljyssl +
                ", isysgb=" + isysgb +
                '}';
    }
}
