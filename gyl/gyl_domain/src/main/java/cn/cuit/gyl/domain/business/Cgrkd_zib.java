package cn.cuit.gyl.domain.business;

import java.io.Serializable;
import java.util.Date;

/**
 * (Cgrkd_zib)实体类
 *
 * @author makejava
 * @since 2020-05-09 18:41:10
 */
public class Cgrkd_zib implements Serializable {

    /**
    * 采购入库单子表id
    */
    private Integer cgrkd_zib_id;
    /**
    * 行号
    */
    private Integer hh;
    /**
    * 商品编码
    */
    private String spbm;
    /**
    * 商品名称
    */
    private String spmc;
    /**
    * 型号
    */
    private String type;
    /**
    * 单位
    */
    private String dw;
    /**
    * 生产日期
    */
    private Date scrq;
    /**
    * 失效日期
    */
    private Date sxrq;
    /**
    * 应到数量
    */
    private Integer ydsl;
    /**
    * 实到数量
    */
    private Integer sdsl;
    /**
    * 单价
    */
    private Double dj;
    /**
    * 金额
    */
    private Double je;
    /**
    * 入库日期
    */
    private Date rkrq;
    /**
    * 赠品 1是 0 不是
    */
    private Integer zp;
    /**
    * 源头单据号
    */
    private String ytdjh;
    /**
    * 源头行号
    */
    private Integer ythh;
    /**
    * 来源单据号
    */
    private String lydjh;
    /**
    * 来源行号
    */
    private Integer lyhh;
    /**
    * 累计入库数量
    */
    private Integer ljrksl;
    /**
    * 是否入库关闭
    */
    private Integer status;
    /**
    * 采购入库单主表id 外键
    */
    private Integer cgrkd_zhub_id;

    @Override
    public String toString() {
        return "Cgdhd_zib{" +
                "cgrkd_zib_id=" + cgrkd_zib_id +
                ", hh=" + hh +
                ", rkrq=" + rkrq +
                ", spbm='" + spbm + '\'' +
                ", spmc='" + spmc + '\'' +
                ", type='" + type + '\'' +
                ", dw='" + dw + '\'' +
                ", scrq=" + scrq +
                ", sxrq=" + sxrq +
                ", ydsl=" + ydsl +
                ", sdsl=" + sdsl +
                ", dj=" + dj +
                ", je=" + je +
                ", zp=" + zp +
                ", ytdjh='" + ytdjh + '\'' +
                ", ythh=" + ythh +
                ", lydjh='" + lydjh + '\'' +
                ", lyhh=" + lyhh +
                ", ljrksl=" + ljrksl +
                ", status=" + status +
                ", cgrkd_zhub_id=" + cgrkd_zhub_id +
                '}';
    }


    public Integer getCgrkd_zib_id() {
        return cgrkd_zib_id;
    }

    public void setCgrkd_zib_id(Integer cgrkdZibId) {
        this.cgrkd_zib_id = cgrkdZibId;
    }

    public Integer getHh() {
        return hh;
    }

    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public String getSpbm() {
        return spbm;
    }

    public void setSpbm(String spbm) {
        this.spbm = spbm;
    }

    public String getSpmc() {
        return spmc;
    }

    public void setSpmc(String spmc) {
        this.spmc = spmc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
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

    public Integer getYdsl() {
        return ydsl;
    }

    public void setYdsl(Integer ydsl) {
        this.ydsl = ydsl;
    }

    public Integer getSdsl() {
        return sdsl;
    }

    public void setSdsl(Integer sdsl) {
        this.sdsl = sdsl;
    }

    public Double getDj() {
        return dj;
    }

    public void setDj(Double dj) {
        this.dj = dj;
    }

    public Double getJe() {
        return je;
    }

    public void setJe(Double je) {
        this.je = je;
    }

    public Date getRkrq() {
        return rkrq;
    }

    public void setRkrq(Date rkrq) {
        this.rkrq = rkrq;
    }

    public Integer getZp() {
        return zp;
    }

    public void setZp(Integer zp) {
        this.zp = zp;
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

    public Integer getLjrksl() {
        return ljrksl;
    }

    public void setLjrksl(Integer ljrksl) {
        this.ljrksl = ljrksl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCgrkdzhubid() {
        return cgrkd_zhub_id;
    }

    public void setCgrkdzhubid(Integer cgrkdzhubid) {
        this.cgrkd_zhub_id = cgrkdzhubid;
    }

}