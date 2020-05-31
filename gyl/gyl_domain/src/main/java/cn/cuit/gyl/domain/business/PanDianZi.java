package cn.cuit.gyl.domain.business;

import java.io.Serializable;
import java.util.Date;

public class PanDianZi implements Serializable {
    private Long id;//子表的id
    private Long zid;//主表的ID
    private Long hh;//行号
    private String chbm;//存货编码
    private String gg;//规格
    private String xh;//型号
    private String dw;//单位
    private String pc;//批次
    private Date scrq;//生产日期
    private Date sxrq;//失效日期
    private Long zmsl;//账面数量（系统数量）
    private Long  pdsl;//盘点数量
    private Long cysl;//差异数量
    private Long tzsl;//调整数量
    private Double sslv;//损失率 (差异除以系统数量)
    private PanDian panDian;//主表

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZid() {
        return zid;
    }

    public void setZid(Long zid) {
        this.zid = zid;
    }

    public Long getHh() {
        return hh;
    }

    public void setHh(Long hh) {
        this.hh = hh;
    }

    public String getChbm() {
        return chbm;
    }

    public void setChbm(String chbm) {
        this.chbm = chbm;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public Date getScrq() {
        return scrq;
    }

    public void setScrq(Date scrq) {
        this.scrq = scrq;
    }

    public Date getSxrq() {
        return sxrq;
    }

    public void setSxrq(Date sxrq) {
        this.sxrq = sxrq;
    }

    public Long getZmsl() {
        return zmsl;
    }

    public void setZmsl(Long zmsl) {
        this.zmsl = zmsl;
    }

    public Long getPdsl() {
        return pdsl;
    }

    public void setPdsl(Long pdsl) {
        this.pdsl = pdsl;
    }

    public Long getCysl() {
        return cysl;
    }

    public void setCysl(Long cysl) {
        this.cysl = cysl;
    }

    public Long getTzsl() {
        return tzsl;
    }

    public void setTzsl(Long tzsl) {
        this.tzsl = tzsl;
    }

    public Double getSslv() {
        return sslv;
    }

    public void setSslv(Double sslv) {
        this.sslv = sslv;
    }

    public PanDian getPanDian() {
        return panDian;
    }

    public void setPanDian(PanDian panDian) {
        this.panDian = panDian;
    }

    @Override
    public String toString() {
        return "PanDianZi{" +
                "id=" + id +
                ", zid=" + zid +
                ", hh=" + hh +
                ", cnbm='" + chbm + '\'' +
                ", gg='" + gg + '\'' +
                ", xh='" + xh + '\'' +
                ", dw='" + dw + '\'' +
                ", bc='" + pc + '\'' +
                ", scrq=" + scrq +
                ", sxrq=" + sxrq +
                ", zmsl=" + zmsl +
                ", pdsl=" + pdsl +
                ", cysl=" + cysl +
                ", tzsl=" + tzsl +
                ", ssl=" + sslv +
                ", panDian=" + panDian +
                '}';
    }
}
