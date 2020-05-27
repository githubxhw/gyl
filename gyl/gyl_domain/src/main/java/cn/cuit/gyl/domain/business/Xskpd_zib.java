package cn.cuit.gyl.domain.business;

//销售开票子表domain 29
public class Xskpd_zib {

    private Integer xskpd_zib_id;//销售开票子表id
    private Integer hh;//行号
    private String spbm;//商品编码
    private String spmc;//商品名称
    private String gg;//规格
    private String dw;//单位
    private String type;//型号
    private Long count;//数量
    private Float rate;//税率
    private Float dpzk;//单品折扣
    private Float zdzk;//整单折扣
    private Float fpzk;//发票折扣
    private Double hsdj;//含税单价
    private Double wsdj;//无税单价
    private Double hsje;//含税金额
    private Double wsje;//无税金额
    private Double zke;//折扣额
    private String ytdjh;//源头单据号
    private Integer ythh;//源头行号
    private String lydjh;//来源单据号
    private Integer lyhh;//来源行号
    private Integer zp;//是否为赠品 1是 0否
    private String zpStr;
    private String ck;//仓库
    private String shdw;//收货单位
    private Long ljkpsl;//累计开票数量
    private Long ljysksl;//累计应收款数量
    private Integer sfyskjs;//是否应收款结束 1是 0否
    private String sfyskjsStr;
    private Integer status;//是否开票结束 1是 0否
    private String statusStr;
    private Integer xskpd_zhub_id;//销售开票主表id  --> 外键

    public Integer getXskpd_zib_id() {
        return xskpd_zib_id;
    }

    public void setXskpd_zib_id(Integer xskpd_zib_id) {
        this.xskpd_zib_id = xskpd_zib_id;
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

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Float getDpzk() {
        return dpzk;
    }

    public void setDpzk(Float dpzk) {
        this.dpzk = dpzk;
    }

    public Float getZdzk() {
        return zdzk;
    }

    public void setZdzk(Float zdzk) {
        this.zdzk = zdzk;
    }

    public Float getFpzk() {
        return fpzk;
    }

    public void setFpzk(Float fpzk) {
        this.fpzk = fpzk;
    }

    public Double getHsdj() {
        return hsdj;
    }

    public void setHsdj(Double hsdj) {
        this.hsdj = hsdj;
    }

    public Double getWsdj() {
        return wsdj;
    }

    public void setWsdj(Double wsdj) {
        this.wsdj = wsdj;
    }

    public Double getHsje() {
        return hsje;
    }

    public void setHsje(Double hsje) {
        this.hsje = hsje;
    }

    public Double getWsje() {
        return wsje;
    }

    public void setWsje(Double wsje) {
        this.wsje = wsje;
    }

    public Double getZke() {
        return zke;
    }

    public void setZke(Double zke) {
        this.zke = zke;
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

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public String getShdw() {
        return shdw;
    }

    public void setShdw(String shdw) {
        this.shdw = shdw;
    }

    public Long getLjkpsl() {
        return ljkpsl;
    }

    public void setLjkpsl(Long ljkpsl) {
        this.ljkpsl = ljkpsl;
    }

    public Long getLjysksl() {
        return ljysksl;
    }

    public void setLjysksl(Long ljysksl) {
        this.ljysksl = ljysksl;
    }

    public Integer getSfyskjs() {
        return sfyskjs;
    }

    public void setSfyskjs(Integer sfyskjs) {
        if(sfyskjs != null){
            if(sfyskjs == 1){
                this.sfyskjsStr = "是";
            }else {
                this.sfyskjsStr = "否";
            }
        }
        this.sfyskjs = sfyskjs;
    }

    public String getSfyskjsStr() {
        return sfyskjsStr;
    }

    public void setSfyskjsStr(String sfyskjsStr) {
        this.sfyskjsStr = sfyskjsStr;
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

    public Integer getXskpd_zhub_id() {
        return xskpd_zhub_id;
    }

    public void setXskpd_zhub_id(Integer xskpd_zhub_id) {
        this.xskpd_zhub_id = xskpd_zhub_id;
    }

    @Override
    public String toString() {
        return "Xskpd_zib{" +
                "xskpd_zib_id=" + xskpd_zib_id +
                ", hh=" + hh +
                ", spbm='" + spbm + '\'' +
                ", spmc='" + spmc + '\'' +
                ", gg='" + gg + '\'' +
                ", dw='" + dw + '\'' +
                ", type='" + type + '\'' +
                ", count=" + count +
                ", rate=" + rate +
                ", dpzk=" + dpzk +
                ", zdzk=" + zdzk +
                ", fpzk=" + fpzk +
                ", hsdj=" + hsdj +
                ", wsdj=" + wsdj +
                ", hsje=" + hsje +
                ", wsje=" + wsje +
                ", zke=" + zke +
                ", ytdjh='" + ytdjh + '\'' +
                ", ythh=" + ythh +
                ", lydjh='" + lydjh + '\'' +
                ", lyhh=" + lyhh +
                ", zp=" + zp +
                ", zpStr='" + zpStr + '\'' +
                ", ck='" + ck + '\'' +
                ", shdw='" + shdw + '\'' +
                ", ljkpsl=" + ljkpsl +
                ", ljysksl=" + ljysksl +
                ", sfyskjs=" + sfyskjs +
                ", sfyskjsStr='" + sfyskjsStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", xskpd_zhub_id=" + xskpd_zhub_id +
                '}';
    }
}
