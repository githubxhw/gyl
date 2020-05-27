package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.util.Date;

//仓库期初子表 12 domain
public class Qc_zib {

    private Long qc_zib_id;//期初子表id
    private Integer hh;//行号
    private String chbm;//存货编码
    private String gg;//规格
    private String xh;//型号
    private String dw;//单位
    private String pc;//批次
    private Long count;//数量
    private Double dj;//单价
    private Double je;//金额
    private Date rkrq;//入库日期
    private String rkrqStr;
    private Long qc_zhub_id;//期初主表id

    //多对一
    private Qc_zhub qc_zhub = null;

    @Override
    public String toString() {
        return "Qc_zib{" +
                "qc_zib_id=" + qc_zib_id +
                ", hh=" + hh +
                ", chbm='" + chbm + '\'' +
                ", gg='" + gg + '\'' +
                ", xh='" + xh + '\'' +
                ", dw='" + dw + '\'' +
                ", pc='" + pc + '\'' +
                ", count=" + count +
                ", dj=" + dj +
                ", je=" + je +
                ", rkrq=" + rkrq +
                ", rkrqStr='" + rkrqStr + '\'' +
                ", qc_zhub_id=" + qc_zhub_id +
                ", qc_zhub=" + qc_zhub +
                '}';
    }

    public Long getQc_zib_id() {
        return qc_zib_id;
    }

    public void setQc_zib_id(Long qc_zib_id) {
        this.qc_zib_id = qc_zib_id;
    }

    public Integer getHh() {
        return hh;
    }

    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public String getChbm() {
        return chbm;
    }

    public void setChbm(String chbm) {
        this.chbm = chbm;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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

    public Date getRkrq() {
        return rkrq;
    }

    public void setRkrq(Date rkrq) {
        if(rkrq!=null){
            this.rkrqStr = ConverterUtils.dateToString(rkrq, "yyyy-MM-dd HH:mm");
        }
        this.rkrq = rkrq;
    }

    public String getRkrqStr() {
        return rkrqStr;
    }

    public void setRkrqStr(String rkrqStr) {
        this.rkrqStr = rkrqStr;
    }

    public Long getQc_zhub_id() {
        return qc_zhub_id;
    }

    public void setQc_zhub_id(Long qc_zhub_id) {
        this.qc_zhub_id = qc_zhub_id;
    }

    public Qc_zhub getQc_zhub() {
        return qc_zhub;
    }

    public void setQc_zhub(Qc_zhub qc_zhub) {
        this.qc_zhub = qc_zhub;
    }
}
