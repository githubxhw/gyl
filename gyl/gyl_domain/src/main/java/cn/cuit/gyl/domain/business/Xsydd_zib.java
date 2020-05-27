package cn.cuit.gyl.domain.business;


import java.io.Serializable;

//销售预订单子表
public class Xsydd_zib implements Serializable {

    private Integer xsydd_zib_id;//销售预订单子表id
    private Integer hh;//行号：标志唯一商品
    private String spmc;//商品名称
    private String spbh;//商品编号
    private String type;//商品型号
    private String jldw;//计量单位
    private Long count = 0L;//数量
    private Float rate;//税率%
    private Float dpkl;//单品扣率
    private Double wsdj;//无税单价
    private Double hsdj;//含税单价
    private Double wsje;//无税金额
    private Double hsje;//含税金额
    private Double se;//税额
    private Double zke;//折扣额
    private String shdw;//收货单位
    private Integer xsydd_zhub_id;//销售预订单主表id

    @Override
    public String toString() {
        return "Xsydd_zib{" +
                "xsydd_zib_id=" + xsydd_zib_id +
                ", hh=" + hh +
                ", spmc='" + spmc + '\'' +
                ", spbh='" + spbh + '\'' +
                ", type='" + type + '\'' +
                ", jldw='" + jldw + '\'' +
                ", count=" + count +
                ", rate=" + rate +
                ", dpkl=" + dpkl +
                ", wsdj=" + wsdj +
                ", hsdj=" + hsdj +
                ", wsje=" + wsje +
                ", hsje=" + hsje +
                ", se=" + se +
                ", zke=" + zke +
                ", shdw='" + shdw + '\'' +
                ", xsydd_zhub_id=" + xsydd_zhub_id +
                '}';
    }

    public Integer getXsydd_zib_id() {
        return xsydd_zib_id;
    }

    public void setXsydd_zib_id(Integer xsydd_zib_id) {
        this.xsydd_zib_id = xsydd_zib_id;
    }

    public Integer getHh() {
        return hh;
    }

    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public String getSpmc() {
        return spmc;
    }

    public void setSpmc(String spmc) {
        this.spmc = spmc;
    }

    public String getSpbh() {
        return spbh;
    }

    public void setSpbh(String spbh) {
        this.spbh = spbh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getDpkl() {
        return dpkl;
    }

    public void setDpkl(Float dpkl) {
        this.dpkl = dpkl;
    }

    public Double getWsdj() {
        return wsdj;
    }

    public void setWsdj(Double wsdj) {
        this.wsdj = wsdj;
    }

    public Double getHsdj() {
        return hsdj;
    }

    public void setHsdj(Double hsdj) {
        this.hsdj = hsdj;
    }

    public Double getWsje() {
        return wsje;
    }

    public void setWsje(Double wsje) {
        this.wsje = wsje;
    }

    public Double getHsje() {
        return hsje;
    }

    public void setHsje(Double hsje) {
        this.hsje = hsje;
    }

    public Double getSe() {
        return se;
    }

    public void setSe(Double se) {
        this.se = se;
    }

    public Double getZke() {
        return zke;
    }

    public void setZke(Double zke) {
        this.zke = zke;
    }

    public String getShdw() {
        return shdw;
    }

    public void setShdw(String shdw) {
        this.shdw = shdw;
    }

    public Integer getXsydd_zhub_id() {
        return xsydd_zhub_id;
    }

    public void setXsydd_zhub_id(Integer xsydd_zhub_id) {
        this.xsydd_zhub_id = xsydd_zhub_id;
    }
}
