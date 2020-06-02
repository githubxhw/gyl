package cn.cuit.gyl.domain.business;

import cn.cuit.gyl.utils.ConverterUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 采购发票主表
 * @author zd
 *
 */
public class Cgfp_zhub implements Serializable{
	private Integer cgfp_zhub_id;//主键
	private String gs;//公司
	private String fph;//发票号
	private String djzt;//单据状态
	private Date fprq;//发票日期
    private String fprqStr;
	private Date pdrq;//票到日期
    private String pdrqStr;
	private String gys;//供应商
	private String cgbm;//采购部门
	private String fplx;//发票类型
	private String ywy;//业务员
	private String bz;//币种
	private Float zdsl;//整单税率
	private Integer isycyf=0;//是否已传应付   1代表已付  0代表未付
    private String isycyfStr;

    //一对多关系
	private List<Cgfp_zib> cgfp_zibs;

    @Override
    public String toString() {
        return "Cgfp_zhub{" +
                "cgfp_zhub_id=" + cgfp_zhub_id +
                ", gs='" + gs + '\'' +
                ", fph='" + fph + '\'' +
                ", djzt='" + djzt + '\'' +
                ", fprq=" + fprq +
                ", fprqStr='" + fprqStr + '\'' +
                ", pdrq=" + pdrq +
                ", pdrqStr='" + pdrqStr + '\'' +
                ", gys='" + gys + '\'' +
                ", cgbm='" + cgbm + '\'' +
                ", fplx='" + fplx + '\'' +
                ", ywy='" + ywy + '\'' +
                ", bz='" + bz + '\'' +
                ", zdsl=" + zdsl +
                ", isycyf=" + isycyf +
                ", isycyfStr='" + isycyfStr + '\'' +
                ", cgfp_zibs=" + cgfp_zibs +
                '}';
    }

    public String getFprqStr() {
        return fprqStr;
    }

    public void setFprqStr(String fprqStr) {
        this.fprqStr = fprqStr;
    }

    public String getPdrqStr() {
        return pdrqStr;
    }

    public void setPdrqStr(String pdrqStr) {
        this.pdrqStr = pdrqStr;
    }

    public Integer getCgfp_zhub_id() {
        return cgfp_zhub_id;
    }

    public void setCgfp_zhub_id(Integer cgfp_zhub_id) {
        this.cgfp_zhub_id = cgfp_zhub_id;
    }

    public String getGs() {
        return gs;
    }

    public void setGs(String gs) {
        this.gs = gs;
    }

    public String getFph() {
        return fph;
    }

    public void setFph(String fph) {
        this.fph = fph;
    }

    public String getDjzt() {
        return djzt;
    }

    public void setDjzt(String djzt) {
        this.djzt = djzt;
    }

    public Date getFprq() {
        return fprq;
    }

    public void setFprq(Date fprq) {
        if(fprq!=null){
            this.fprqStr= ConverterUtils.dateToString(fprq,"yyyy-MM-dd HH:mm");
        }
        this.fprq = fprq;
    }

    public Date getPdrq() {
        return pdrq;
    }

    public void setPdrq(Date pdrq) {
        if(pdrq!=null){
            this.pdrqStr= ConverterUtils.dateToString(pdrq,"yyyy-MM-dd HH:mm");
        }
        this.pdrq = pdrq;
    }

    public String getGys() {
        return gys;
    }

    public void setGys(String gys) {
        this.gys = gys;
    }

    public String getCgbm() {
        return cgbm;
    }

    public void setCgbm(String cgbm) {
        this.cgbm = cgbm;
    }

    public String getFplx() {
        return fplx;
    }

    public void setFplx(String fplx) {
        this.fplx = fplx;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Float getZdsl() {
        return zdsl;
    }

    public void setZdsl(Float zdsl) {
        this.zdsl = zdsl;
    }

    public Integer getIsycyf() {
        return isycyf;
    }

    public String getIsycyfStr() {
        return isycyfStr;
    }

    public void setIsycyfStr(String isycyfStr) {
        this.isycyfStr = isycyfStr;
    }

    public void setIsycyf(Integer isycyf) {
        if(isycyf != null){
            if(isycyf == 1){
                this.isycyfStr = "已付";
            }else{
                this.isycyfStr = "未付";
            }
        }
        this.isycyf = isycyf;
    }

    public List<Cgfp_zib> getCgfp_zibs() {
        return cgfp_zibs;
    }

    public void setCgfp_zibs(List<Cgfp_zib> cgfp_zibs) {
        this.cgfp_zibs = cgfp_zibs;
    }
}
