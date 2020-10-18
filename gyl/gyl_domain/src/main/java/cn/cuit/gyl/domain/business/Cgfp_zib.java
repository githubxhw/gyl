package cn.cuit.gyl.domain.business;
import java.io.Serializable;

/**
 * 采购发票子表
 * @author zd
 *
 */
public class Cgfp_zib implements Serializable{
	private Integer cgfp_zib_id;//主键
	private Integer hh;//行号  标志唯一商品
	private String chbm;//存货编码
	private String chmc;//存货名称
	private String gg;//规格
	private String xh;//型号
	private Double wsdj;//无税单价
	private String pc;//批次
	private Long fpsl=0L;//发票数量
	private Float je;//金额
	private String bz;//币种
	private Float hsdj;//含税单价
	private Float sl;//税率
	private Float se;//税额
	private Float wsje;//无税金额
	private String lydjh;//来源单据号  订单或者入库单
	private String lyhh;//来源行号  订单或者入库单
	private String ytdjd;//源头单据号
	private String ythh;//源头行号
	private Integer status;//是否开票结束 1是 0否
	private String statusStr;


	private Integer cgfp_zhub_id; //采购发票主表id 外键

	public Integer getCgfp_zhub_id() {
		return cgfp_zhub_id;
	}

	public void setCgfp_zhub_id(Integer cgfp_zhub_id) {
		this.cgfp_zhub_id = cgfp_zhub_id;
	}

	@Override
	public String toString() {
		return "Cgfp_zib{" +
				"cgfp_zib_id=" + cgfp_zib_id +
				", hh=" + hh +
				", chbm='" + chbm + '\'' +
				", chmc='" + chmc + '\'' +
				", gg='" + gg + '\'' +
				", xh='" + xh + '\'' +
				", wsdj=" + wsdj +
				", pc='" + pc + '\'' +
				", fpsl=" + fpsl +
				", je=" + je +
				", bz='" + bz + '\'' +
				", hsdj=" + hsdj +
				", sl=" + sl +
				", se=" + se +
				", wsje=" + wsje +
				", lydjh='" + lydjh + '\'' +
				", lyhh='" + lyhh + '\'' +
				", ytdjd='" + ytdjd + '\'' +
				", ythh='" + ythh + '\'' +
				", cgfpzhub=" + cgfpzhub +
				'}';
	}

	private Cgfp_zhub cgfpzhub;

	public Integer getCgfp_zib_id() {
		return cgfp_zib_id;
	}

	public void setCgfp_zib_id(Integer cgfp_zib_id) {
		this.cgfp_zib_id = cgfp_zib_id;
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

	public String getChmc() {
		return chmc;
	}

	public void setChmc(String chmc) {
		this.chmc = chmc;
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

	public Double getWsdj() {
		return wsdj;
	}

	public void setWsdj(Double wsdj) {
		this.wsdj = wsdj;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public Long getFpsl() {
		return fpsl;
	}

	public void setFpsl(Long fpsl) {
		this.fpsl = fpsl;
	}

	public Float getJe() {
		return je;
	}

	public void setJe(Float je) {
		this.je = je;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Float getHsdj() {
		return hsdj;
	}

	public void setHsdj(Float hsdj) {
		this.hsdj = hsdj;
	}

	public Float getSl() {
		return sl;
	}

	public void setSl(Float sl) {
		this.sl = sl;
	}

	public Float getSe() {
		return se;
	}

	public void setSe(Float se) {
		this.se = se;
	}

	public Float getWsje() {
		return wsje;
	}

	public void setWsje(Float wsje) {
		this.wsje = wsje;
	}

	public String getLydjh() {
		return lydjh;
	}

	public void setLydjh(String lydjh) {
		this.lydjh = lydjh;
	}

	public String getLyhh() {
		return lyhh;
	}

	public void setLyhh(String lyhh) {
		this.lyhh = lyhh;
	}

	public String getYtdjd() {
		return ytdjd;
	}

	public void setYtdjd(String ytdjd) {
		this.ytdjd = ytdjd;
	}

	public String getYthh() {
		return ythh;
	}

	public void setYthh(String ythh) {
		this.ythh = ythh;
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

	public Cgfp_zhub getCgfpzhub() {
		return cgfpzhub;
	}

	public void setCgfpzhub(Cgfp_zhub cgfpzhub) {
		this.cgfpzhub = cgfpzhub;
	}
}
