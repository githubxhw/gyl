package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.util.Date;
import java.util.List;

//销售开票主表domain 25
public class Xskpd_zhub {

    private Integer xskpd_zhub_id;//销售开票主表id
    private String fph;//开票号
    private Date kprq;//开票日期
    private String kprqStr;
    private String fplx;//发票类型  专用发票  普通发票  营业税  收据  其他  增值税发票
    private Date kjnd;//会计年度  用的是哪年的发票
    private String kjndStr;
    private String kh;//客户
    private String khdymc;//客户打印名称
    private String bm;//部门
    private String ywy;//业务员
    private String shdw;//收货单位
    private String shdz;//收货地址
    private Float zdzk;//整单折扣
    private String ck;//仓库
    private String bz;//币种
    private Double fpzje;//发票总金额   当前开票订单中所以的子表的含税金额的总和
    private String zdr;//制单人
    private Date zdrq;//制单日期
    private String zdrqStr;
    private String spr;//审批人
    private Date sprq;//审批日期
    private String sprqStr;
    private Integer sfsp;//是否审批
    private String sfspStr;
    private Integer spsftg;//审批是否通过
    private String spsftgStr;
    private String xgr;//修改人
    private Date xgrq;//修改日期
    private String xgrqStr;
    private Integer ysksfjs;//应收款是否结束 1结束 0未结束
    private String ysksfjsStr;
    private Integer status;//单据状态
    private String statusStr;

    //子表
    private List<Xskpd_zib> xskpd_zibs;

    public String getKjndStr() {
        return kjndStr;
    }

    public void setKjndStr(String kjndStr) {
        this.kjndStr = kjndStr;
    }

    public Integer getXskpd_zhub_id() {
        return xskpd_zhub_id;
    }

    public void setXskpd_zhub_id(Integer xskpd_zhub_id) {
        this.xskpd_zhub_id = xskpd_zhub_id;
    }

    public String getFph() {
        return fph;
    }

    public void setFph(String fph) {
        this.fph = fph;
    }

    public Date getKprq() {
        return kprq;
    }

    public void setKprq(Date kprq) {
        if(kprq != null){
            this.kprqStr = ConverterUtils.dateToString(kprq, "yyyy-MM-dd HH:mm");
        }
        this.kprq = kprq;
    }

    public String getKprqStr() {
        return kprqStr;
    }

    public void setKprqStr(String kprqStr) {
        this.kprqStr = kprqStr;
    }

    public String getFplx() {
        return fplx;
    }

    public void setFplx(String fplx) {
        this.fplx = fplx;
    }

    public Date getKjnd() {
        return kjnd;
    }

    public void setKjnd(Date kjnd) {
        if(kjnd != null){
            this.kjndStr = ConverterUtils.dateToString(kjnd, "yyyy-MM-dd HH:mm");
        }
        this.kjnd = kjnd;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getKhdymc() {
        return khdymc;
    }

    public void setKhdymc(String khdymc) {
        this.khdymc = khdymc;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public String getShdw() {
        return shdw;
    }

    public void setShdw(String shdw) {
        this.shdw = shdw;
    }

    public String getShdz() {
        return shdz;
    }

    public void setShdz(String shdz) {
        this.shdz = shdz;
    }

    public Float getZdzk() {
        return zdzk;
    }

    public void setZdzk(Float zdzk) {
        this.zdzk = zdzk;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Double getFpzje() {
        return fpzje;
    }

    public void setFpzje(Double fpzje) {
        this.fpzje = fpzje;
    }

    public String getZdr() {
        return zdr;
    }

    public void setZdr(String zdr) {
        this.zdr = zdr;
    }

    public Date getZdrq() {
        return zdrq;
    }

    public void setZdrq(Date zdrq) {
        if(zdrq != null){
            this.zdrqStr = ConverterUtils.dateToString(zdrq, "yyyy-MM-dd HH:mm");
        }
        this.zdrq = zdrq;
    }

    public String getZdrqStr() {
        return zdrqStr;
    }

    public void setZdrqStr(String zdrqStr) {
        this.zdrqStr = zdrqStr;
    }

    public String getSpr() {
        return spr;
    }

    public void setSpr(String spr) {
        this.spr = spr;
    }

    public Date getSprq() {
        return sprq;
    }

    public void setSprq(Date sprq) {
        if(sprq != null){
            this.sprqStr = ConverterUtils.dateToString(sprq, "yyyy-MM-dd HH:mm");
        }
        this.sprq = sprq;
    }

    public String getSprqStr() {
        return sprqStr;
    }

    public void setSprqStr(String sprqStr) {
        this.sprqStr = sprqStr;
    }

    public Integer getSfsp() {
        return sfsp;
    }

    public void setSfsp(Integer sfsp) {
        if(sfsp != null){
            if(sfsp == 1){
                this.sfspStr = "是";
            }else {
                this.sfspStr = "否";
            }
        }
        this.sfsp = sfsp;
    }

    public String getSfspStr() {
        return sfspStr;
    }

    public void setSfspStr(String sfspStr) {
        this.sfspStr = sfspStr;
    }

    public Integer getSpsftg() {
        return spsftg;
    }

    public void setSpsftg(Integer spsftg) {
        if(spsftg != null){
            if(spsftg == 1){
                this.spsftgStr = "是";
            }else {
                this.spsftgStr = "否";
            }
        }
        this.spsftg = spsftg;
    }

    public String getSpsftgStr() {
        return spsftgStr;
    }

    public void setSpsftgStr(String spsftgStr) {
        this.spsftgStr = spsftgStr;
    }

    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    public Date getXgrq() {
        return xgrq;
    }

    public void setXgrq(Date xgrq) {
        if(xgrq != null){
            this.xgrqStr = ConverterUtils.dateToString(xgrq, "yyyy-MM-dd HH:mm");
        }
        this.xgrq = xgrq;
    }

    public String getXgrqStr() {
        return xgrqStr;
    }

    public void setXgrqStr(String xgrqStr) {
        this.xgrqStr = xgrqStr;
    }

    public Integer getYsksfjs() {
        return ysksfjs;
    }

    public void setYsksfjs(Integer ysksfjs) {
        if(ysksfjs != null){
            if(ysksfjs == 1){
                this.ysksfjsStr = "是";
            }else {
                this.ysksfjsStr = "否";
            }
        }
        this.ysksfjs = ysksfjs;
    }

    public String getYsksfjsStr() {
        return ysksfjsStr;
    }

    public void setYsksfjsStr(String ysksfjsStr) {
        this.ysksfjsStr = ysksfjsStr;
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

    public List<Xskpd_zib> getXskpd_zibs() {
        return xskpd_zibs;
    }

    public void setXskpd_zibs(List<Xskpd_zib> xskpd_zibs) {
        this.xskpd_zibs = xskpd_zibs;
    }

    @Override
    public String toString() {
        return "Xskpd_zhub{" +
                "xskpd_zhub_id=" + xskpd_zhub_id +
                ", fph='" + fph + '\'' +
                ", kprq=" + kprq +
                ", kprqStr='" + kprqStr + '\'' +
                ", fplx='" + fplx + '\'' +
                ", kjnd=" + kjnd +
                ", kjndStr='" + kjndStr + '\'' +
                ", kh='" + kh + '\'' +
                ", khdymc='" + khdymc + '\'' +
                ", bm='" + bm + '\'' +
                ", ywy='" + ywy + '\'' +
                ", shdw='" + shdw + '\'' +
                ", shdz='" + shdz + '\'' +
                ", zdzk=" + zdzk +
                ", ck='" + ck + '\'' +
                ", bz='" + bz + '\'' +
                ", fpzje=" + fpzje +
                ", zdr='" + zdr + '\'' +
                ", zdrq=" + zdrq +
                ", zdrqStr='" + zdrqStr + '\'' +
                ", spr='" + spr + '\'' +
                ", sprq=" + sprq +
                ", sprqStr='" + sprqStr + '\'' +
                ", sfsp=" + sfsp +
                ", sfspStr='" + sfspStr + '\'' +
                ", spsftg=" + spsftg +
                ", spsftgStr='" + spsftgStr + '\'' +
                ", xgr='" + xgr + '\'' +
                ", xgrq=" + xgrq +
                ", xgrqStr='" + xgrqStr + '\'' +
                ", ysksfjs=" + ysksfjs +
                ", ysksfjsStr='" + ysksfjsStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", xskpd_zibs=" + xskpd_zibs +
                '}';
    }


}
