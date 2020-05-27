package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.util.Date;

//销售发货单子表domain
public class Xsfhd_zib {

    private Integer xsfhd_zib_id;//销售发货单子表id
    private Integer hh;//行号
    private Date fhrq;//发货日期
    private String fhrqStr;
    private String spbm;//存货编码
    private String spmc;//存货名称
    private String type;//型号
    private String dw;//单位
    private Date scrq;//生产日期
    private String scrqStr;
    private Date sxrq;//失效日期
    private String sxrqStr;
    private Long yfsl;//应发数量
    private Long sfsl;//实发数量
    private Double dj;//单价
    private Double je;//金额
    private Integer zp;//赠品 1是 0不是
    private String zpStr;
    private String ytdjh;//源头单据号
    private Integer ythh;//源头行号
    private String lydjh;//来源单据号
    private Integer lyhh;//来源行号
    private Long ljfhsl;//累计发货数量
    private Long ljcksl;//累计出库数量
    private Long ljkpsl;//累计开票数量
    private Integer sfckjs;//是否出库结束 1结束 0未结束
    private String sfckjsStr;
    private Integer sfkpjs;//是否开票结束 1结束 0未结束
    private String sfkpjsStr;
    private Integer status;//是否发货关闭 1没有 0关闭
    private String statusStr;
    private Integer xsfhd_zhub_id;//销售出库单主表id 外键

    @Override
    public String toString() {
        return "Xsfhd_zib{" +
                "xsfhd_zib_id=" + xsfhd_zib_id +
                ", hh=" + hh +
                ", fhrq=" + fhrq +
                ", fhrqStr='" + fhrqStr + '\'' +
                ", spbm='" + spbm + '\'' +
                ", spmc='" + spmc + '\'' +
                ", type='" + type + '\'' +
                ", dw='" + dw + '\'' +
                ", scrq=" + scrq +
                ", scrqStr='" + scrqStr + '\'' +
                ", sxrq=" + sxrq +
                ", sxrqStr='" + sxrqStr + '\'' +
                ", yfsl=" + yfsl +
                ", sfsl=" + sfsl +
                ", dj=" + dj +
                ", je=" + je +
                ", zp=" + zp +
                ", zpStr='" + zpStr + '\'' +
                ", ytdjh='" + ytdjh + '\'' +
                ", ythh=" + ythh +
                ", lydjh='" + lydjh + '\'' +
                ", lyhh=" + lyhh +
                ", ljfhsl=" + ljfhsl +
                ", ljcksl=" + ljcksl +
                ", ljkpsl=" + ljkpsl +
                ", sfckjs=" + sfckjs +
                ", sfckjsStr='" + sfckjsStr + '\'' +
                ", sfkpjs=" + sfkpjs +
                ", sfkpjsStr='" + sfkpjsStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", xsfhd_zhub_id=" + xsfhd_zhub_id +
                '}';
    }

    public Long getLjkpsl() {
        return ljkpsl;
    }

    public void setLjkpsl(Long ljkpsl) {
        this.ljkpsl = ljkpsl;
    }

    public Integer getSfkpjs() {
        return sfkpjs;
    }

    public void setSfkpjs(Integer sfkpjs) {
        if(sfkpjs != null){
            if(sfkpjs == 1){
                this.sfkpjsStr = "是";
            }else {
                this.sfkpjsStr = "否";
            }
        }
        this.sfkpjs = sfkpjs;
    }

    public String getSfkpjsStr() {
        return sfkpjsStr;
    }

    public void setSfkpjsStr(String sfkpjsStr) {
        this.sfkpjsStr = sfkpjsStr;
    }

    public Long getLjcksl() {
        return ljcksl;
    }

    public void setLjcksl(Long ljcksl) {
        this.ljcksl = ljcksl;
    }

    public Integer getSfckjs() {
        return sfckjs;
    }

    public void setSfckjs(Integer sfckjs) {
        if(sfckjs != null){
            if(sfckjs == 1){
                this.sfckjsStr = "是";
            }else {
                this.sfckjsStr = "否";
            }
        }
        this.sfckjs = sfckjs;
    }

    public String getSfckjsStr() {
        return sfckjsStr;
    }

    public void setSfckjsStr(String sfckjsStr) {
        this.sfckjsStr = sfckjsStr;
    }

    public Integer getXsfhd_zib_id() {
        return xsfhd_zib_id;
    }

    public void setXsfhd_zib_id(Integer xsfhd_zib_id) {
        this.xsfhd_zib_id = xsfhd_zib_id;
    }

    public Integer getHh() {
        return hh;
    }

    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public Date getFhrq() {
        return fhrq;
    }

    public void setFhrq(Date fhrq) {
        if(fhrq != null){
            this.fhrqStr = ConverterUtils.dateToString(fhrq, "yyyy-MM-dd HH:mm");
        }
        this.fhrq = fhrq;
    }

    public String getFhrqStr() {
        return fhrqStr;
    }

    public void setFhrqStr(String fhrqStr) {
        this.fhrqStr = fhrqStr;
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

    public Long getYfsl() {
        return yfsl;
    }

    public void setYfsl(Long yfsl) {
        this.yfsl = yfsl;
    }

    public Long getSfsl() {
        return sfsl;
    }

    public void setSfsl(Long sfsl) {
        this.sfsl = sfsl;
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

    public Long getLjfhsl() {
        return ljfhsl;
    }

    public void setLjfhsl(Long ljfhsl) {
        this.ljfhsl = ljfhsl;
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

    public Integer getXsfhd_zhub_id() {
        return xsfhd_zhub_id;
    }

    public void setXsfhd_zhub_id(Integer xsfhd_zhub_id) {
        this.xsfhd_zhub_id = xsfhd_zhub_id;
    }
}
