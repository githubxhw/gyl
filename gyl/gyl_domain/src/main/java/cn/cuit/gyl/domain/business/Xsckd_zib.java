package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.io.Serializable;
import java.util.Date;

//销售出库单子表domain 22 3125px
public class Xsckd_zib implements Serializable {

    private Integer xsckd_zib_id;//销售出库单子表id
    private Integer hh;//行号
    private String spbm;//存货编码
    private String spmc;//存货名称
    private String type;//型号
    private String dw;//单位
    private Date scrq;//生产日期
    private String scrqStr;
    private Date sxrq;//失效日期
    private String sxrqStr;
    private Long yfsl;//应发数量 对应【发货单子表】的实发数量
    private Long sfsl;//实发数量
    private Double dj;//单价
    private Double je;//金额
    private Date ckrq;//出库日期
    private String ckrqStr;
    private Integer zp;//赠品 1是 0 不是
    private String zpStr;
    private String ytdjh;//源头单据号
    private Integer ythh;//源头行号
    private String lydjh;//来源单据号
    private Integer lyhh;//来源行号
    private Long ljcksl;//累计出库数量 对应【发货单子表】的累计出库数量 -->根据 来源单据号 和 来源行号 来
    private Integer status;//是否出库关闭
    private String statusStr;
    private Integer xsckd_zhub_id;//销售出库单主表id 外键

    @Override
    public String toString() {
        return "Xsckd_zib{" +
                "xsckd_zib_id=" + xsckd_zib_id +
                ", hh=" + hh +
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
                ", ckrq=" + ckrq +
                ", ckrqStr='" + ckrqStr + '\'' +
                ", zp=" + zp +
                ", zpStr='" + zpStr + '\'' +
                ", ytdjh='" + ytdjh + '\'' +
                ", ythh=" + ythh +
                ", lydjh='" + lydjh + '\'' +
                ", lyhh=" + lyhh +
                ", ljcksl=" + ljcksl +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", xsckd_zhub_id=" + xsckd_zhub_id +
                '}';
    }

    public Integer getXsckd_zib_id() {
        return xsckd_zib_id;
    }

    public void setXsckd_zib_id(Integer xsckd_zib_id) {
        this.xsckd_zib_id = xsckd_zib_id;
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
        if (scrq != null) {
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
        if (sxrq != null) {
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

    public Date getCkrq() {
        return ckrq;
    }

    public void setCkrq(Date ckrq) {
        if (ckrq != null) {
            this.ckrqStr = ConverterUtils.dateToString(ckrq, "yyyy-MM-dd HH:mm");
        }
        this.ckrq = ckrq;
    }

    public String getCkrqStr() {
        return ckrqStr;
    }

    public void setCkrqStr(String ckrqStr) {
        this.ckrqStr = ckrqStr;
    }

    public Integer getZp() {
        return zp;
    }

    public void setZp(Integer zp) {
        if (zp != null) {
            if (zp == 1) {
                this.zpStr = "是";
            } else {
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

    public Long getLjcksl() {
        return ljcksl;
    }

    public void setLjcksl(Long ljcksl) {
        this.ljcksl = ljcksl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        if (status != null) {
            if (status == 1) {
                this.statusStr = "结束";
            } else {
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

    public Integer getXsckd_zhub_id() {
        return xsckd_zhub_id;
    }

    public void setXsckd_zhub_id(Integer xsckd_zhub_id) {
        this.xsckd_zhub_id = xsckd_zhub_id;
    }
}
