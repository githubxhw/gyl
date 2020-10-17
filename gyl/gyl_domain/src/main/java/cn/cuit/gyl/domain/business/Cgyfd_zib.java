package cn.cuit.gyl.domain.business;

import java.io.Serializable;

/**
 * (Cgyfd_zib)实体类
 *
 * @author makejava
 * @since 2020-06-09 20:43:57
 */
public class Cgyfd_zib implements Serializable {
    /**
    * 采购应付单子表
    */
    private Integer cgyfd_zib_id;
    /**
    * 实付数量
    */
    private Integer sl;
    /**
    * 行号
    */
    private Integer hh;
    /**
    * 商品名称
    */
    private String spmc;
    /**
    * 商品编码
    */
    private String spbm;
    /**
    * 含税金额
    */
    private Integer hsje;
    /**
    * 单位
    */
    private String dw;
    /**
    * 税额
    */
    private Float se;
    /**
    * 无税金额
    */
    private Integer wsje;
    /**
    * 来源单据号
    */
    private String lydjh;
    /**
    * 来源行号
    */
    private Integer lyhh;
    /**
    * 源头单据号
    */
    private String ytdjh;
    /**
    * 源头行号
    */
    private Integer ythh;
    /**
    * 单价
    */
    private Float dj;
    /**
    * 累计应付数量
    */
    private Integer ljyfsl;
    /**
    * 是否应付关闭
    */
    private Integer status;
    /**
    * 主表id
    */
    private Integer zhu_id;


    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
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

    public Integer getHsje() {
        return hsje;
    }

    public void setHsje(Integer hsje) {
        this.hsje = hsje;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public Float getSe() {
        return se;
    }

    public void setSe(Float se) {
        this.se = se;
    }

    public Integer getWsje() {
        return wsje;
    }

    public void setWsje(Integer wsje) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getCgyfd_zib_id() {
        return cgyfd_zib_id;
    }

    public void setCgyfd_zib_id(Integer cgyfd_zib_id) {
        this.cgyfd_zib_id = cgyfd_zib_id;
    }

    public Integer getHh() {
        return hh;
    }


    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public Integer getLjyfsl() {
        return ljyfsl;
    }

    public void setLjyfsl(Integer ljyfsl) {
        this.ljyfsl = ljyfsl;
    }

    public Integer getZhu_id() {
        return zhu_id;
    }

    public void setZhu_id(Integer zhu_id) {
        this.zhu_id = zhu_id;
    }
}