package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.util.Date;

//采购到货单子表domain
public class Cgdhd_zib {

    private Integer cgdhd_zib_id;//采购到货单子表id
    private Integer hh;//行号
    private Date dhrq;//到货日期
    private String dhrqStr;
    private String spbm;//存货编码
    private String spmc;//存货名称
    private String type;//型号
    private String dw;//单位
    private Date scrq;//生产日期
    private String scrqStr;
    private Date sxrq;//失效日期
    private String sxrqStr;
    private Long ydsl;//应到数量
    private Long sdsl;//实到数量
    private Long dhwrksl;//到货但是没有入库的数量
    private Long dhwkpsl;//到货但是没有开票的数量
    private Double dj;//单价
    private Double je;//金额
    private Integer zp;//赠品 1是 0不是
    private String zpStr;
    private String ytdjh;//源头单据号
    private Integer ythh;//源头行号
    private String lydjh;//来源单据号
    private Integer lyhh;//来源行号
    private Long ljdhsl;//累计到货数量
    private Integer sfrkjs;//是否入库结束 1结束 0未结束
    private String sfrkjsStr;
    private Integer status;//是否到货关闭 1没有 0关闭
    private String statusStr;
    private Integer cgdhd_zhub_id;//销售入库单主表id 外键

    @Override
    public String toString() {
        return "Cgdhd_zib{" +
                "cgdhd_zib_id=" + cgdhd_zib_id +
                ", hh=" + hh +
                ", dhrq=" + dhrq +
                ", dhrqStr='" + dhrqStr + '\'' +
                ", spbm='" + spbm + '\'' +
                ", spmc='" + spmc + '\'' +
                ", type='" + type + '\'' +
                ", dw='" + dw + '\'' +
                ", scrq=" + scrq +
                ", scrqStr='" + scrqStr + '\'' +
                ", sxrq=" + sxrq +
                ", sxrqStr='" + sxrqStr + '\'' +
                ", ydsl=" + ydsl +
                ", sdsl=" + sdsl +
                ", dhwrksl=" + dhwrksl +
                ", dhwkpsl=" + dhwkpsl +
                ", dj=" + dj +
                ", je=" + je +
                ", zp=" + zp +
                ", zpStr='" + zpStr + '\'' +
                ", ytdjh='" + ytdjh + '\'' +
                ", ythh=" + ythh +
                ", lydjh='" + lydjh + '\'' +
                ", lyhh=" + lyhh +
                ", ljdhsl=" + ljdhsl +
                ", sfrkjs=" + sfrkjs +
                ", sfrkjsStr='" + sfrkjsStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", cgdhd_zhub_id=" + cgdhd_zhub_id +
                '}';
    }

    public Integer getSfrkjs() {
        return sfrkjs;
    }

    public void setSfrkjs(Integer sfrkjs) {
        if(sfrkjs != null){
            if(sfrkjs == 1){
                this.sfrkjsStr = "结束";
            }else {
                this.sfrkjsStr = "未结束";
            }
        }
        this.sfrkjs = sfrkjs;
    }

    public String getSfrkjsStr() {
        return sfrkjsStr;
    }

    public void setSfrkjsStr(String sfrkjsStr) {
        this.sfrkjsStr = sfrkjsStr;
    }

    public Integer getCgdhd_zib_id() {
        return cgdhd_zib_id;
    }

    public void setCgdhd_zib_id(Integer cgdhd_zib_id) {
        this.cgdhd_zib_id = cgdhd_zib_id;
    }

    public Integer getHh() {
        return hh;
    }

    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public Date getDhrq() {
        return dhrq;
    }

    public void setDhrq(Date dhrq) {
        if(dhrq != null){
            this.dhrqStr = ConverterUtils.dateToString(dhrq, "yyyy-MM-dd HH:mm");
        }
        this.dhrq = dhrq;
    }

    public String getDhrqStr() {
        return dhrqStr;
    }

    public void setDhrqStr(String dhrqStr) {
        this.dhrqStr = dhrqStr;
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
        if(scrq != null){
            this.scrqStr = ConverterUtils.dateToString(scrq, "yyyy-MM-dd HH:mm");
        }
        this.scrq = scrq;
    }

    public String getScrqStr() {
        return scrqStr;
    }

    public void setScrqStr(String scrqStr) {
        this.scrqStr = scrqStr;
    }

    public Date getSxrq() {
        return sxrq;
    }

    public void setSxrq(Date sxrq) {
        if(sxrq != null){
            this.sxrqStr = ConverterUtils.dateToString(sxrq, "yyyy-MM-dd HH:mm");
        }
        this.sxrq = sxrq;
    }

    public String getSxrqStr() {
        return sxrqStr;
    }

    public void setSxrqStr(String sxrqStr) {
        this.sxrqStr = sxrqStr;
    }

    public Long getYdsl() {
        return ydsl;
    }

    public void setYdsl(Long ydsl) {
        this.ydsl = ydsl;
    }

    public Long getSdsl() {
        return sdsl;
    }

    public void setSdsl(Long sdsl) {
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

    public Integer getZp() {
        return zp;
    }

    public void setZp(Integer zp) {
        if(zp != null){
            if(zp == 1){
                this.zpStr = "是";
            }else {
                this.zpStr = "否";
            }
        }
        this.zp = zp;
    }

    public String getZpStr() {
        return zpStr;
    }

    public void setZpStr(String zpStr) {
        this.zpStr = zpStr;
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

    public Long getLjdhsl() {
        return ljdhsl;
    }

    public void setLjdhsl(Long ljdhsl) {
        this.ljdhsl = ljdhsl;
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

    public Integer getCgdhd_zhub_id() {
        return cgdhd_zhub_id;
    }

    public void setCgdhd_zhub_id(Integer cgdhd_zhub_id) {
        this.cgdhd_zhub_id = cgdhd_zhub_id;
    }

    public Long getDhwrksl() {
        return dhwrksl;
    }

    public void setDhwrksl(Long dhwrksl) {
        this.dhwrksl = dhwrksl;
    }

    public Long getDhwkpsl() {
        return dhwkpsl;
    }

    public void setDhwkpsl(Long dhwkpsl) {
        this.dhwkpsl = dhwkpsl;
    }
}

