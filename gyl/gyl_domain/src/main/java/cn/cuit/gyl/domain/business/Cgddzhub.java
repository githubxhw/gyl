package cn.cuit.gyl.domain.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 采购订单主表
 * @author zd
 *
 */
@JsonIgnoreProperties(value = { "handler" })
public class Cgddzhub implements Serializable{
	private Long cgddzhubid;//主键
	private String gs;//公司

	private String djh;//单据号
	private String gys;//供应商
	private String cgbm;//采购部门
	private String cgr;//采购人
	private Integer isth;//是否退货
	private String jdr;//解冻人
	private Date ddrq;//订单日期
	private Integer status;//状态
	private String bz;//币种
	private Float zdsl;//整单税率
	private Integer djzt;//冻结状态
	private String spr;//审批人
	private Date sprq;//审批日期
	private Integer issp;//审批是否通过
	private Integer spsftg; //审批是否通过 1代表通过 0代表未通过
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String xgr;//修改人
	private Date xgrq;//修改日期
	private Date sxrq; //失效日期
	private String ywy; //业务员
	private Double zdshj; //整单价税合计 ：子表中的 含税金额 全部相加
	private Integer dhbz = 0; //到货结束标志 1 代表发货结束 0代表没有发货结束
	private Integer rkbz = 0; //入库结束标志 1 代表出库结束 0代表没有出库结束
	private Integer kpbz = 0; //开票结束标志 1 代表开票结束 0代表没有开票结束
	private String kpdw; //开票单位
	private String dhdq; //到货地区
	private String dhdz; //到货地址
	private Integer ysbz = 0; //应收结束标志 1 代表开票结束 0代表没有开票结束


	private List<Cgddzhib> cgddzhibs;

	public Date getSxrq() {
		return sxrq;
	}

	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}

	public String getYwy() {
		return ywy;
	}

	public void setYwy(String ywy) {
		this.ywy = ywy;
	}

	public Double getZdshj() {
		return zdshj;
	}

	public void setZdshj(Double zdshj) {
		this.zdshj = zdshj;
	}

	public Integer getDhbz() {
		return dhbz;
	}

	public void setDhbz(Integer dhbz) {
		this.dhbz = dhbz;
	}



	public Integer getRkbz() {
		return rkbz;
	}

	public void setRkbz(Integer rkbz) {
		this.rkbz = rkbz;
	}



	public Integer getKpbz() {
		return kpbz;
	}

	public void setKpbz(Integer kpbz) {
		this.kpbz = kpbz;
	}

	public String getKpdw() {
		return kpdw;
	}

	public void setKpdw(String kpdw) {
		this.kpdw = kpdw;
	}

	public String getDhdq() {
		return dhdq;
	}

	public void setDhdq(String dhdq) {
		this.dhdq = dhdq;
	}

	public String getDhdz() {
		return dhdz;
	}

	public void setDhdz(String dhdz) {
		this.dhdz = dhdz;
	}

	public Integer getYsbz() {
		return ysbz;
	}

	public void setYsbz(Integer ysbz) {
		this.ysbz = ysbz;
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

	public Integer getSpsftg() {
		return spsftg;
	}

	public void setSpsftg(Integer spsftg) {
		this.spsftg = spsftg;
	}

	public void setIssp(Integer issp) {
		this.issp = issp;
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

	public void setZdrq(Date zdprq) {
		this.zdrq = zdprq;
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







	public Long getCgddzhubid() {
		return cgddzhubid;
	}

	public void setCgddzhubid(Long cgddzhubid) {
		this.cgddzhubid = cgddzhubid;
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

	public String getCgr() {
		return cgr;
	}

	public void setCgr(String cgr) {
		this.cgr = cgr;
	}

	public Integer getIsth() {
		return isth;
	}

	public void setIsth(Integer isth) {
		this.isth = isth;
	}

	public String getJdr() {
		return jdr;
	}

	public void setJdr(String jdr) {
		this.jdr = jdr;
	}


	public Date getDdrq() {
		return ddrq;
	}

	public void setDdrq(Date ddrq) {
		this.ddrq = ddrq;
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

	public Integer getDjzt() {
		return djzt;
	}

	public void setDjzt(Integer djzt) {
		this.djzt = djzt;
	}

	public List<Cgddzhib> getCgddzhibs() {
		return cgddzhibs;
	}

	public void setCgddzhibs(List<Cgddzhib> cgddzhibs) {
		this.cgddzhibs = cgddzhibs;
	}

	@Override
	public String toString() {
		return "Cgddzhub{" +
				"cgddzhubid=" + cgddzhubid +
				", gs='" + gs + '\'' +
				", djh='" + djh + '\'' +
				", gys='" + gys + '\'' +
				", cgbm='" + cgbm + '\'' +
				", cgr='" + cgr + '\'' +
				", isth=" + isth +
				", jdr='" + jdr + '\'' +
				", ddrq=" + ddrq +
				", status=" + status +
				", bz='" + bz + '\'' +
				", zdsl=" + zdsl +
				", djzt=" + djzt +
				", spr='" + spr + '\'' +
				", sprq=" + sprq +
				", issp=" + issp +
				", spsftg=" + spsftg +
				", zdr='" + zdr + '\'' +
				", zdrq=" + zdrq +
				", xgr='" + xgr + '\'' +
				", xgrq=" + xgrq +
				", sxrq=" + sxrq +
				", ywy='" + ywy + '\'' +
				", zdshj=" + zdshj +
				", dhbz=" + dhbz +
				", rkbz=" + rkbz +
				", kpbz=" + kpbz +
				", kpdw='" + kpdw + '\'' +
				", dhdq='" + dhdq + '\'' +
				", dhdz='" + dhdz + '\'' +
				", ysbz=" + ysbz +
				", cgddzhibs=" + cgddzhibs +
				'}';
	}
}
