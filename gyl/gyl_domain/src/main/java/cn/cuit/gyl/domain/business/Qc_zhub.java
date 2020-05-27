package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.util.Date;
import java.util.List;

//仓库期初主表 20 domain
public class Qc_zhub {

    private Long qc_zhub_id;//期初表的主表id
    private String gs;//公司
    private String djh;//单据号
    private Date djrq;//单据日期
    private String djrqStr;
    private String ckbm;//仓库(编码)
    private String kcy;//库存员名称（唯一）
    private String bm;//部门
    private String zdr;//制单人
    private Date zdrq;//制单日期
    private String zdrqStr;
    private String qzr;//签字人
    private Date qzrq;//签字日期
    private String qzrqStr;
    private Integer sfsp;//是否审批
    private String sfspStr;
    private Integer spsftg;//审批是否通过
    private String spsftgStr;
    private String xgr;//修改人
    private Date xgrq;//修改日期
    private String xgrqStr;
    private Integer status;//单据状态
    private String statusStr;


    //多表
    List<Qc_zib> qc_zibs;

    @Override
    public String toString() {
        return "Qc_zhub{" +
                "qc_zhub_id=" + qc_zhub_id +
                ", gs='" + gs + '\'' +
                ", djh='" + djh + '\'' +
                ", djrq=" + djrq +
                ", djrqStr='" + djrqStr + '\'' +
                ", ckbm='" + ckbm + '\'' +
                ", kcy='" + kcy + '\'' +
                ", bm='" + bm + '\'' +
                ", zdr='" + zdr + '\'' +
                ", zdrq=" + zdrq +
                ", zdrqStr='" + zdrqStr + '\'' +
                ", qzr='" + qzr + '\'' +
                ", qzrq=" + qzrq +
                ", qzrqStr='" + qzrqStr + '\'' +
                ", sfsp=" + sfsp +
                ", sfspStr='" + sfspStr + '\'' +
                ", spsftg=" + spsftg +
                ", spsftgStr='" + spsftgStr + '\'' +
                ", xgr='" + xgr + '\'' +
                ", xgrq=" + xgrq +
                ", xgrqStr='" + xgrqStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", qc_zibs=" + qc_zibs +
                '}';
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

    public Long getQc_zhub_id() {
        return qc_zhub_id;
    }

    public void setQc_zhub_id(Long qc_zhub_id) {
        this.qc_zhub_id = qc_zhub_id;
    }

    public String getGs() {
        return gs;
    }

    public void setGs(String gs) {
        this.gs = gs;
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    public Date getDjrq() {
        return djrq;
    }

    public void setDjrq(Date djrq) {
        if(djrq!=null){
            this.djrqStr = ConverterUtils.dateToString(djrq, "yyyy-MM-dd HH:mm");
        }
        this.djrq = djrq;
    }

    public String getDjrqStr() {
        return djrqStr;
    }

    public void setDjrqStr(String djrqStr) {
        this.djrqStr = djrqStr;
    }

    public String getCkbm() {
        return ckbm;
    }

    public void setCkbm(String ckbm) {
        this.ckbm = ckbm;
    }

    public String getKcy() {
        return kcy;
    }

    public void setKcy(String kcy) {
        this.kcy = kcy;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
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
        if(zdrq!=null){
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

    public String getQzr() {
        return qzr;
    }

    public void setQzr(String qzr) {
        this.qzr = qzr;
    }

    public Date getQzrq() {
        return qzrq;
    }

    public void setQzrq(Date qzrq) {
        if(qzrq!=null){
            this.qzrqStr = ConverterUtils.dateToString(qzrq, "yyyy-MM-dd HH:mm");
        }
        this.qzrq = qzrq;
    }

    public String getQzrqStr() {
        return qzrqStr;
    }

    public void setQzrqStr(String qzrqStr) {
        this.qzrqStr = qzrqStr;
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
        if(xgrq!=null){
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

    public List<Qc_zib> getQc_zibs() {
        return qc_zibs;
    }

    public void setQc_zibs(List<Qc_zib> qc_zibs) {
        this.qc_zibs = qc_zibs;
    }
}
