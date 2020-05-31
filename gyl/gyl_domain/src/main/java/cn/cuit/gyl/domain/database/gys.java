package cn.cuit.gyl.domain.database;

import java.io.Serializable;

public class gys implements Serializable {
    private Long id;
    private String name;//名字
    private String fullname;//全称
    private String zjm;//助记码
    private String jc;//简称
    private String dz;//地址
    private Integer status;//状态 0为没使用 1为使用
    private String qy;//区域
    private String hy;//行业
    private String lxr;//联系人
    private String dh;//电话
    private String mdh;//移动电话
    private String cz;//传真
    private String yb;//邮编
    private String email;//邮件地址
    private String khyh;//开户银行
    private String yhzh;//银行账号
    private String swdjh;//税务登记号
    private Float zzsl;//增值税率
    private String gj;//国家

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getZjm() {
        return zjm;
    }

    public void setZjm(String zjm) {
        this.zjm = zjm;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getQy() {
        return qy;
    }

    public void setQy(String qy) {
        this.qy = qy;
    }

    public String getHy() {
        return hy;
    }

    public void setHy(String hy) {
        this.hy = hy;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getMdh() {
        return mdh;
    }

    public void setMdh(String mdh) {
        this.mdh = mdh;
    }

    public String getCz() {
        return cz;
    }

    public void setCz(String cz) {
        this.cz = cz;
    }

    public String getYb() {
        return yb;
    }

    public void setYb(String yb) {
        this.yb = yb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }

    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }

    public String getSwdjh() {
        return swdjh;
    }

    public void setSwdjh(String swdjh) {
        this.swdjh = swdjh;
    }

    public Float getZzsl() {
        return zzsl;
    }

    public void setZzsl(Float zzsl) {
        this.zzsl = zzsl;
    }

    public String getGj() {
        return gj;
    }

    public void setGj(String gj) {
        this.gj = gj;
    }

    @Override
    public String toString() {
        return "gys{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullname='" + fullname + '\'' +
                ", zjm='" + zjm + '\'' +
                ", jc='" + jc + '\'' +
                ", dz='" + dz + '\'' +
                ", status=" + status +
                ", qy='" + qy + '\'' +
                ", hy='" + hy + '\'' +
                ", lxr='" + lxr + '\'' +
                ", dh='" + dh + '\'' +
                ", mdh='" + mdh + '\'' +
                ", cz='" + cz + '\'' +
                ", yb='" + yb + '\'' +
                ", email='" + email + '\'' +
                ", khyh='" + khyh + '\'' +
                ", yhzh='" + yhzh + '\'' +
                ", swdjh='" + swdjh + '\'' +
                ", zzsl='" + zzsl + '\'' +
                ", gj='" + gj + '\'' +
                '}';
    }
}
