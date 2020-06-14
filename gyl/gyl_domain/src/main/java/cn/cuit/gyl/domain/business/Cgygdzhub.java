package cn.cuit.gyl.domain.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 采购请购单主表
 * @author zd
 *
 */
@JsonIgnoreProperties(value = { "handler" })
public class Cgygdzhub implements Serializable{
	private Long cgqgdzhubid;//主键
	private String gs;//公司
	private String djh;//单据号
	private String qggys;//请购供应商
	private String cgbm;//采购部门
	private String cgr;//采购人
	private Date qgrq;//请购日期
	private Integer status;//状态  0=没结束  1=结束
	private String bz;//币种
	private Float zdsl;//整单税率
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String xgr;//修改人
	private Date xgrq;//修改日期
	private String spr;//审批人
	private Date sprq;//审批日期
	private Integer issp;//是否审批
	private Integer spsftg; //审批是否通过 1代表通过 0代表未通过
	
	private List<Cgygdzhib> cgqgdzhibs;//采购请购单子表

	public Long getCgqgdzhubid() {
		return cgqgdzhubid;
	}

	public void setCgqgdzhubid(Long cgqgdzhubid) {
		this.cgqgdzhubid = cgqgdzhubid;
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

	public String getQggys() {
		return qggys;
	}

	public void setQggys(String qggys) {
		this.qggys = qggys;
	}

	public String getCgbm() {
		return cgbm;
	}

	public void setCgbm(String cgbm) {
		this.cgbm = cgbm;
	}

	public String getCgr() {
		return cgr;
	}

	public void setCgr(String cgr) {
		this.cgr = cgr;
	}

	public Date getQgrq() {
		return qgrq;
	}

	public void setQgrq(Date qgrq) {
		this.qgrq = qgrq;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public List<Cgygdzhib> getCgqgdzhibs() {
		return cgqgdzhibs;
	}

	public void setCgqgdzhibs(List<Cgygdzhib> cgqgdzhibs) {
		this.cgqgdzhibs = cgqgdzhibs;
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
		this.zdrq = zdrq;
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
		this.xgrq = xgrq;
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
		this.sprq = sprq;
	}

	public Integer getIssp() {
		return issp;
	}

	public void setIssp(Integer issp) {
		this.issp = issp;
	}

	public Integer getSpsftg() {
		return spsftg;
	}

	public void setSpsftg(Integer spsftg) {
		this.spsftg = spsftg;
	}

	@Override
	public String toString() {
		return "Cgygdzhub{" +
				"cgqgdzhubid=" + cgqgdzhubid +
				", gs='" + gs + '\'' +
				", djh='" + djh + '\'' +
				", qggys='" + qggys + '\'' +
				", cgbm='" + cgbm + '\'' +
				", cgr='" + cgr + '\'' +
				", qgrq=" + qgrq +
				", status='" + status + '\'' +
				", bz='" + bz + '\'' +
				", zdsl=" + zdsl +
				", zdr='" + zdr + '\'' +
				", zdrq=" + zdrq +
				", xgr='" + xgr + '\'' +
				", xgrq=" + xgrq +
				", spr='" + spr + '\'' +
				", sprq=" + sprq +
				", issp=" + issp +
				", spsftg=" + spsftg +
				", cgqgdzhibs=" + cgqgdzhibs +
				'}';
	}
}
