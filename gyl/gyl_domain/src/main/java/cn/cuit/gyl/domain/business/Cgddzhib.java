package cn.cuit.gyl.domain.business;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购订单子表
 * @author zd
 *
 */
public class Cgddzhib implements Serializable{
	private Long cgddzhibid;//主键
	private Long hh;//行号
	private Long zid;//主表的id
	private String spbm;//商品编码
	private String spmc;//商品名称
	private Integer hgb;//行关闭
	private String gbr;//关闭人
	private Date gbrq;//关闭日期
	private String gg;//规格
	private String xh;//型号
	private Long sl;//数量
	private String dw;//单位
	private Float hsdj;//含税单价
	private Float wsdj;//无税单价
	private Float shuilv;//税率 
	private Float hsje;//含税金额
	private Float wsje;//无税金额
	private Float se;//税额
	private String zp;//赠品
	private String lydj;//来源单据
	private Long ljthsl;//累计退货数量
	private Integer hstatus;//行状态
	private String shck; //到货仓库
	private String fhdw; //发货单位
	private Date jhfhrq; //计划发货日期
	private Date yqshrq; //要求收货日期
	private Long yfwrksl = 0L; //应发未入库数量
	private Long ljdhsl = 0L; //累计到货数量
	private Long ljrksl = 0L; //累计入库数量
	private Long ljkpsl = 0L; //累计开票数量
	private Long ljyssl = 0L; //累计应收数量
	private Integer sfdhgb = 0; //是否到货结束 关闭 0没有关闭 1关闭
	private Integer sfrkgb = 0; //是否入库结束 关闭 0没有关闭 1关闭
	private Integer sfkpgb = 0; //是否开票结束 关闭 0没有关闭 1关闭
	private Integer sffkgb = 0; //是否付款结束 关闭 0没有关闭 1关闭
	
	private Cgddzhub cgddzhub ;

	public String getShck() {
		return shck;
	}

	public void setShck(String shck) {
		this.shck = shck;
	}

	public String getFhdw() {
		return fhdw;
	}

	public void setFhdw(String fhdw) {
		this.fhdw = fhdw;
	}

	public Date getJhfhrq() {
		return jhfhrq;
	}

	public void setJhfhrq(Date jhfhrq) {
		this.jhfhrq = jhfhrq;
	}

	public Date getYqshrq() {
		return yqshrq;
	}

	public void setYqshrq(Date yqshrq) {
		this.yqshrq = yqshrq;
	}

	public Long getYfwrksl() {
		return yfwrksl;
	}

	public void setYfwrksl(Long yfwrksl) {
		this.yfwrksl = yfwrksl;
	}

	public Long getLjdhsl() {
		return ljdhsl;
	}

	public void setLjdhsl(Long ljdhsl) {
		this.ljdhsl = ljdhsl;
	}

	public Long getLjrksl() {
		return ljrksl;
	}

	public void setLjrksl(Long ljrksl) {
		this.ljrksl = ljrksl;
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

	public Integer getSfdhgb() {
		return sfdhgb;
	}

	public void setSfdhgb(Integer sfdhgb) {
		this.sfdhgb = sfdhgb;
	}

	public Integer getSfrkgb() {
		return sfrkgb;
	}

	public void setSfrkgb(Integer sfrkgb) {
		this.sfrkgb = sfrkgb;
	}

	public Integer getSfkpgb() {
		return sfkpgb;
	}

	public void setSfkpgb(Integer sfkpgb) {
		this.sfkpgb = sfkpgb;
	}

	public Integer getSffkgb() {
		return sffkgb;
	}

	public void setSffkgb(Integer sffkgb) {
		this.sffkgb = sffkgb;
	}

	public Long getCgddzhibid() {
		return cgddzhibid;
	}

	public void setCgddzhibid(Long cgddzhibid) {
		this.cgddzhibid = cgddzhibid;
	}

	public Long getHh() {
		return hh;
	}

	public void setHh(Long hh) {
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

	public Integer getHgb() {
		return hgb;
	}

	public void setHgb(Integer hgb) {
		this.hgb = hgb;
	}

	public String getGbr() {
		return gbr;
	}

	public void setGbr(String gbr) {
		this.gbr = gbr;
	}

	public Date getGbrq() {
		return gbrq;
	}

	public void setGbrq(Date gbrq) {
		this.gbrq = gbrq;
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

	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public Float getHsdj() {
		return hsdj;
	}

	public void setHsdj(Float hsdj) {
		this.hsdj = hsdj;
	}

	public Float getWsdj() {
		return wsdj;
	}

	public void setWsdj(Float wsdj) {
		this.wsdj = wsdj;
	}

	public Float getShuilv() {
		return shuilv;
	}

	public void setShuilv(Float shuilv) {
		this.shuilv = shuilv;
	}

	public Float getHsje() {
		return hsje;
	}

	public void setHsje(Float hsje) {
		this.hsje = hsje;
	}

	public Float getWsje() {
		return wsje;
	}

	public void setWsje(Float wsje) {
		this.wsje = wsje;
	}

	public Float getSe() {
		return se;
	}

	public void setSe(Float se) {
		this.se = se;
	}

	public String getZp() {
		return zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public String getLydj() {
		return lydj;
	}

	public void setLydj(String lydj) {
		this.lydj = lydj;
	}

	public Long getLjthsl() {
		return ljthsl;
	}

	public void setLjthsl(Long ljthsl) {
		this.ljthsl = ljthsl;
	}

	public Integer getHstatus() {
		return hstatus;
	}

	public void setHstatus(Integer hstatus) {
		this.hstatus = hstatus;
	}

	public Cgddzhub getCgddzhub() {
		return cgddzhub;
	}

	public void setCgddzhub(Cgddzhub cgddzhub) {
		this.cgddzhub = cgddzhub;
	}

	public Long getZid() {
		return zid;
	}

	public void setZid(Long zid) {
		this.zid = zid;
	}

	@Override
	public String toString() {
		return "Cgddzhib{" +
				"cgddzhibid=" + cgddzhibid +
				", hh=" + hh +
				", zid=" + zid +
				", spbm='" + spbm + '\'' +
				", spmc='" + spmc + '\'' +
				", hgb=" + hgb +
				", gbr='" + gbr + '\'' +
				", gbrq=" + gbrq +
				", gg='" + gg + '\'' +
				", xh='" + xh + '\'' +
				", sl=" + sl +
				", dw='" + dw + '\'' +
				", hsdj=" + hsdj +
				", wsdj=" + wsdj +
				", shuilv=" + shuilv +
				", hsje=" + hsje +
				", wsje=" + wsje +
				", se=" + se +
				", zp='" + zp + '\'' +
				", lydj='" + lydj + '\'' +
				", ljthsl=" + ljthsl +
				", hstatus=" + hstatus +
				", shck='" + shck + '\'' +
				", fhdw='" + fhdw + '\'' +
				", jhfhrq=" + jhfhrq +
				", yqshrq=" + yqshrq +
				", yfwrksl=" + yfwrksl +
				", ljdhsl=" + ljdhsl +
				", ljrksl=" + ljrksl +
				", ljkpsl=" + ljkpsl +
				", ljyssl=" + ljyssl +
				", sfdhgb=" + sfdhgb +
				", sfrkgb=" + sfrkgb +
				", sfkpgb=" + sfkpgb +
				", sffkgb=" + sffkgb +
				", cgddzhub=" + cgddzhub +
				'}';
	}
}
