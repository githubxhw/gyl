package cn.cuit.gyl.domain.business;


import cn.cuit.gyl.utils.ConverterUtils;

import java.util.Date;

//销售订单子表
public class Xsdd_zib {

    private Integer xsdd_zib_id; //销售订单子表id

    private Integer hh; //行号：标志唯一商品
    private Integer lyhh; //来源行号:  如果是退货单，而退货单又是根据销售订单生成的，指向该销售订单的行号
    private String spbm; //商品编码
    private String spmc; //商品名称
    private String type; //型号
    private String jldw; //计量单位

    private Long count; //数量
    private Float rate; //税率%
    private Float dpkl; //单品扣率%
    private Double wsdj; //无税单价
    private Double hsdj; //含税单价
    private Double wsje; //无税金额
    private Double hsje; //含税金额
    private Double se; //税额
    private Double zke; //折扣额

    private String fhck; //发货仓库
    private String shdw; //收货单位
    private Date jhfhrq; //计划发货日期
    private String jhfhrqStr;
    private Date yqshrq; //要求收货日期
    private String yqshrqStr;

    private Integer zp = 0; //是否是赠品   如果是1表示是赠品，如果是0是不赠品
    private String zpStr;

    private Long yfwcksl = 0L; //应发未出库数量
    private Long ljfhsl = 0L; //累计发货数量
    private Long ljcksl = 0L; //累计出库数量
    private Long ljkpsl = 0L; //累计开票数量
    private Long ljyssl = 0L; //累计应收数量

    private Integer sffhgb = 0; //是否发货结束 关闭 0没有关闭 1关闭
    private String sffhgbStr;
    private Integer sfckgb = 0; //是否出库结束 关闭 0没有关闭 1关闭
    private String sfckgbStr;
    private Integer sfkpgb = 0; //是否开票结束 关闭 0没有关闭 1关闭
    private String sfkpgbStr;
    private Integer sfskgb = 0; //是否收款结束 关闭 0没有关闭 1关闭
    private String sfskgbStr;

    private Integer status = 0; //状态   1表示已完成   0表示未完成 把某一种商品的销售环节走完以后，这种商品所在的行就关闭了
    private String statusStr;
    private Integer xsdd_zhub_id; //销售订单主表id 外键

    @Override
    public String toString() {
        return "Xsdd_zib{" +
                "xsdd_zib_id=" + xsdd_zib_id +
                ", hh=" + hh +
                ", lyhh=" + lyhh +
                ", spbm='" + spbm + '\'' +
                ", spmc='" + spmc + '\'' +
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
                ", fhck='" + fhck + '\'' +
                ", shdw='" + shdw + '\'' +
                ", jhfhrq=" + jhfhrq +
                ", jhfhrqStr='" + jhfhrqStr + '\'' +
                ", yqshrq=" + yqshrq +
                ", yqshrqStr='" + yqshrqStr + '\'' +
                ", zp=" + zp +
                ", zpStr='" + zpStr + '\'' +
                ", yfwcksl=" + yfwcksl +
                ", ljfhsl=" + ljfhsl +
                ", ljcksl=" + ljcksl +
                ", ljkpsl=" + ljkpsl +
                ", ljyssl=" + ljyssl +
                ", sffhgb=" + sffhgb +
                ", sffhgbStr='" + sffhgbStr + '\'' +
                ", sfckgb=" + sfckgb +
                ", sfckgbStr='" + sfckgbStr + '\'' +
                ", sfkpgb=" + sfkpgb +
                ", sfkpgbStr='" + sfkpgbStr + '\'' +
                ", sfskgb=" + sfskgb +
                ", sfskgbStr='" + sfskgbStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", xsdd_zhub_id=" + xsdd_zhub_id +
                '}';
    }

    public String getJhfhrqStr() {
        return jhfhrqStr;
    }

    public void setJhfhrqStr(String jhfhrqStr) {
        this.jhfhrqStr = jhfhrqStr;
    }

    public String getYqshrqStr() {
        return yqshrqStr;
    }

    public void setYqshrqStr(String yqshrqStr) {
        this.yqshrqStr = yqshrqStr;
    }

    public String getZpStr() {
        return zpStr;
    }

    public void setZpStr(String zpStr) {
        this.zpStr = zpStr;
    }

    public String getSffhgbStr() {
        return sffhgbStr;
    }

    public void setSffhgbStr(String sffhgbStr) {
        this.sffhgbStr = sffhgbStr;
    }

    public String getSfckgbStr() {
        return sfckgbStr;
    }

    public void setSfckgbStr(String sfckgbStr) {
        this.sfckgbStr = sfckgbStr;
    }

    public String getSfkpgbStr() {
        return sfkpgbStr;
    }

    public void setSfkpgbStr(String sfkpgbStr) {
        this.sfkpgbStr = sfkpgbStr;
    }

    public String getSfskgbStr() {
        return sfskgbStr;
    }

    public void setSfskgbStr(String sfskgbStr) {
        this.sfskgbStr = sfskgbStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getXsdd_zib_id() {
        return xsdd_zib_id;
    }

    public void setXsdd_zib_id(Integer xsdd_zib_id) {
        this.xsdd_zib_id = xsdd_zib_id;
    }

    public Integer getHh() {
        return hh;
    }

    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public Integer getLyhh() {
        return lyhh;
    }

    public void setLyhh(Integer lyhh) {
        this.lyhh = lyhh;
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

    public String getFhck() {
        return fhck;
    }

    public void setFhck(String fhck) {
        this.fhck = fhck;
    }

    public String getShdw() {
        return shdw;
    }

    public void setShdw(String shdw) {
        this.shdw = shdw;
    }

    public Date getJhfhrq() {
        return jhfhrq;
    }

    public void setJhfhrq(Date jhfhrq) {
        if(jhfhrq != null){
            this.jhfhrqStr = ConverterUtils.dateToString(jhfhrq, "yyyy-MM-dd HH:mm");
        }
        this.jhfhrq = jhfhrq;
    }

    public Date getYqshrq() {
        return yqshrq;
    }

    public void setYqshrq(Date yqshrq) {
        if(yqshrq != null){
            this.yqshrqStr = ConverterUtils.dateToString(yqshrq, "yyyy-MM-dd HH:mm");
        }
        this.yqshrq = yqshrq;
    }

    public Integer getZp() {
        return zp;
    }

    public void setZp(Integer zp) {
        if(zp != null){
            if(zp == 1){
                this.zpStr = "是";
            }else{
                this.zpStr = "否";
            }
        }
        this.zp = zp;
    }

    public Long getYfwcksl() {
        return yfwcksl;
    }

    public void setYfwcksl(Long yfwcksl) {
        this.yfwcksl = yfwcksl;
    }

    public Long getLjfhsl() {
        return ljfhsl;
    }

    public void setLjfhsl(Long ljfhsl) {
        this.ljfhsl = ljfhsl;
    }

    public Long getLjcksl() {
        return ljcksl;
    }

    public void setLjcksl(Long ljcksl) {
        this.ljcksl = ljcksl;
    }

    public Long getLjkpsl() {
        return ljkpsl;
    }

    public void setLjkpsl(Long ljkpsl) {
        this.ljkpsl = ljkpsl;
    }

    public Long getLjyssl() {
        return ljyssl;
    }

    public void setLjyssl(Long ljyssl) {
        this.ljyssl = ljyssl;
    }

    public Integer getSffhgb() {
        return sffhgb;
    }

    public void setSffhgb(Integer sffhgb) {
        if(sffhgb != null){
            if(sffhgb == 1){
                this.sffhgbStr = "结束";
            }else{
                this.sffhgbStr = "未结束";
            }
        }
        this.sffhgb = sffhgb;
    }

    public Integer getSfckgb() {
        return sfckgb;
    }

    public void setSfckgb(Integer sfckgb) {
        if(sfckgb != null){
            if(sfckgb == 1){
                this.sfckgbStr = "结束";
            }else{
                this.sfckgbStr = "未结束";
            }
        }
        this.sfckgb = sfckgb;
    }

    public Integer getSfkpgb() {
        return sfkpgb;
    }

    public void setSfkpgb(Integer sfkpgb) {
        if(sfkpgb != null){
            if(sfkpgb == 1){
                this.sfkpgbStr = "结束";
            }else{
                this.sfkpgbStr = "未结束";
            }
        }
        this.sfkpgb = sfkpgb;
    }

    public Integer getSfskgb() {
        return sfskgb;
    }

    public void setSfskgb(Integer sfskgb) {
        if(sfskgb != null){
            if(sfskgb == 1){
                this.sfskgbStr = "结束";
            }else{
                this.sfskgbStr = "未结束";
            }
        }
        this.sfskgb = sfskgb;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        if(status != null){
            if(status == 1){
                this.statusStr = "结束";
            }else{
                this.statusStr = "未结束";
            }
        }
        this.status = status;
    }

    public Integer getXsdd_zhub_id() {
        return xsdd_zhub_id;
    }

    public void setXsdd_zhub_id(Integer xsdd_zhub_id) {
        this.xsdd_zhub_id = xsdd_zhub_id;
    }
}
