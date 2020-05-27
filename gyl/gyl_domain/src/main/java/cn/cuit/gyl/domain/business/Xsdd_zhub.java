package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.util.Date;
import java.util.List;

//销售订单主表 28
public class Xsdd_zhub {

    private Integer xsdd_zhub_id; //销售订单主表id
    private String ddh; //订单号 13
    private Date dhrq; //订货日期
    private String dhrqStr;
    private Date sxrq; //失效日期
    private String sxrqStr;
    private String khmc; //客户名称
    private String xsbm; //销售部门
    private String ywy; //业务员
    private String spr; //审批人
    private Date sprq; //审批日期
    private String sprqStr;
    private Integer sfsp = 0;//是否审批 1已经审批 0还没有审批
    private String sfspStr;
    private Integer spsftg = 0; //审批是否通过 1代表通过 0代表未通过
    private String spsftgStr;
    private String zdr; //制单人
    private Date zdrq; //制单日期
    private String zdrqStr;
    private String xgr; //修改人
    private Date xgrq; //修改日期
    private String xgrqStr;
    private Float zdks; //整单扣率
    private String kpdw; //开票单位
    private String shdq; //收货地区
    private String shdz; //收货地址
    private Double zdshj; //整单价税合计 ：子表中的 含税金额 全部相加
    private Double sxkje; //收现款金额 : 相当于现款或者定金

    private String lydjh; //来源单据号:可能没有预订单，就未null
    private Integer thbz = 0; //退货标志 1代表退货 0代表不退货
    private String thbzStr;
    private Integer fhbz = 0; //发货结束标志 1 代表发货结束 0代表没有发货结束
    private String fhbzStr;
    private Integer ckbz = 0; //出库结束标志 1 代表出库结束 0代表没有出库结束
    private String ckbzStr;
    private Integer kpbz = 0; //开票结束标志 1 代表开票结束 0代表没有开票结束
    private String kpbzStr;
    private Integer ysbz = 0; //应收结束标志 1 代表开票结束 0代表没有开票结束
    private String ysbzStr;
    private Integer status = 0; //状态   1表示已完成   0表示未完成
    private String statusStr;

    //一对多关系
    private List<Xsdd_zib> xsdd_zibs;

    @Override
    public String toString() {
        return "Xsdd_zhub{" +
                "xsdd_zhub_id=" + xsdd_zhub_id +
                ", ddh='" + ddh + '\'' +
                ", dhrq=" + dhrq +
                ", dhrqStr='" + dhrqStr + '\'' +
                ", sxrq=" + sxrq +
                ", sxrqStr='" + sxrqStr + '\'' +
                ", khmc='" + khmc + '\'' +
                ", xsbm='" + xsbm + '\'' +
                ", ywy='" + ywy + '\'' +
                ", spr='" + spr + '\'' +
                ", sprq=" + sprq +
                ", sprqStr='" + sprqStr + '\'' +
                ", sfsp=" + sfsp +
                ", sfspStr='" + sfspStr + '\'' +
                ", spsftg=" + spsftg +
                ", spsftgStr='" + spsftgStr + '\'' +
                ", zdr='" + zdr + '\'' +
                ", zdrq=" + zdrq +
                ", zdrqStr='" + zdrqStr + '\'' +
                ", xgr='" + xgr + '\'' +
                ", xgrq=" + xgrq +
                ", xgrqStr='" + xgrqStr + '\'' +
                ", zdks=" + zdks +
                ", kpdw='" + kpdw + '\'' +
                ", shdq='" + shdq + '\'' +
                ", shdz='" + shdz + '\'' +
                ", zdshj=" + zdshj +
                ", sxkje=" + sxkje +
                ", lydjh='" + lydjh + '\'' +
                ", thbz=" + thbz +
                ", thbzStr='" + thbzStr + '\'' +
                ", fhbz=" + fhbz +
                ", fhbzStr='" + fhbzStr + '\'' +
                ", ckbz=" + ckbz +
                ", ckbzStr='" + ckbzStr + '\'' +
                ", kpbz=" + kpbz +
                ", kpbzStr='" + kpbzStr + '\'' +
                ", ysbz=" + ysbz +
                ", ysbzStr='" + ysbzStr + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", xsdd_zibs=" + xsdd_zibs +
                '}';
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
                this.spsftgStr = "通过";
            }else {
                this.spsftgStr = "未通过";
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

    public Integer getYsbz() {
        return ysbz;
    }

    public void setYsbz(Integer ysbz) {
        if(ysbz != null){
           if(ysbz == 1){
               this.ysbzStr = "结束";
           }else {
               this.ysbzStr = "未结束";
           }
        }
        this.ysbz = ysbz;
    }

    public String getYsbzStr() {
        return ysbzStr;
    }

    public void setYsbzStr(String ysbzStr) {
        this.ysbzStr = ysbzStr;
    }

    public String getThbzStr() {
        return thbzStr;
    }

    public void setThbzStr(String thbzStr) {
        this.thbzStr = thbzStr;
    }

    public String getFhbzStr() {
        return fhbzStr;
    }

    public void setFhbzStr(String fhbzStr) {
        this.fhbzStr = fhbzStr;
    }

    public String getKpbzStr() {
        return kpbzStr;
    }

    public void setKpbzStr(String kpbzStr) {
        this.kpbzStr = kpbzStr;
    }

    public String getCkbzStr() {
        return ckbzStr;
    }

    public void setCkbzStr(String ckbzStr) {
        this.ckbzStr = ckbzStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getXsdd_zhub_id() {
        return xsdd_zhub_id;
    }

    public void setXsdd_zhub_id(Integer xsdd_zhub_id) {
        this.xsdd_zhub_id = xsdd_zhub_id;
    }

    public String getDdh() {
        return ddh;
    }

    public void setDdh(String ddh) {
        this.ddh = ddh;
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

    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc;
    }

    public String getXsbm() {
        return xsbm;
    }

    public void setXsbm(String xsbm) {
        this.xsbm = xsbm;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
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

    public Float getZdks() {
        return zdks;
    }

    public void setZdks(Float zdks) {
        this.zdks = zdks;
    }

    public String getKpdw() {
        return kpdw;
    }

    public void setKpdw(String kpdw) {
        this.kpdw = kpdw;
    }

    public String getShdq() {
        return shdq;
    }

    public void setShdq(String shdq) {
        this.shdq = shdq;
    }

    public String getShdz() {
        return shdz;
    }

    public void setShdz(String shdz) {
        this.shdz = shdz;
    }

    public Double getZdshj() {
        return zdshj;
    }

    public void setZdshj(Double zdshj) {
        this.zdshj = zdshj;
    }

    public Double getSxkje() {
        return sxkje;
    }

    public void setSxkje(Double sxkje) {
        this.sxkje = sxkje;
    }

    public String getLydjh() {
        return lydjh;
    }

    public void setLydjh(String lydjh) {
        this.lydjh = lydjh;
    }

    public Integer getThbz() {
        return thbz;
    }

    public void setThbz(Integer thbz) {
        if(thbz != null){
            if(thbz == 1){
                this.thbzStr = "退货";
            }else{
                this.thbzStr = "未退货";
            }
        }
        this.thbz = thbz;
    }

    public Integer getFhbz() {
        return fhbz;
    }

    public void setFhbz(Integer fhbz) {
        if(fhbz != null){
            if(fhbz == 1){
                this.fhbzStr = "结束";
            }else{
                this.fhbzStr = "未结束";
            }
        }
        this.fhbz = fhbz;
    }

    public Integer getKpbz() {
        return kpbz;
    }

    public void setKpbz(Integer kpbz) {
        if(kpbz != null){
            if(kpbz == 1){
                this.kpbzStr = "结束";
            }else{
                this.kpbzStr = "未结束";
            }
        }
        this.kpbz = kpbz;
    }

    public Integer getCkbz() {
        return ckbz;
    }

    public void setCkbz(Integer ckbz) {
        if(ckbz != null){
            if(ckbz == 1){
                this.ckbzStr = "结束";
            }else{
                this.ckbzStr = "未结束";
            }
        }
        this.ckbz = ckbz;
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

    public List<Xsdd_zib> getXsdd_zibs() {
        return xsdd_zibs;
    }

    public void setXsdd_zibs(List<Xsdd_zib> xsdd_zibs) {
        this.xsdd_zibs = xsdd_zibs;
    }
}
