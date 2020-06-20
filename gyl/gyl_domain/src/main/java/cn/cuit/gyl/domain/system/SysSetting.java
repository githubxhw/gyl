package cn.cuit.gyl.domain.system;

public class SysSetting {

    private Integer id;//系统设置id
    private Integer cgEarlyWarningDays;//采购入库提前预警天数
    private Integer cgEarlyWarningInvalidDays;//采购入库日期失效后的连续预警天数
    private Integer cgEarlyWarningDaysBeforeRetention;//保留采购没有预警且在保留天数之内的数据项
    private Integer storeEarlyWarningDays;//仓库提前预警天数
    private Integer fhEarlyWarningDays;//销售出库提前预警天数
    private Integer fhEarlyWarningInvalidDays;//销售出库日期失效后的连续预警天数
    private Integer fhEarlyWarningDaysBeforeRetention;//保留销售没有预警且在保留天数之内的数据项
    private Integer syslogDaysBeforeRetention;//保留前几天的日志天数
    private Integer isUsersLoginForbidden;//是否禁止所有用户登录（除了拥有系统设置的用户）1是 0否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCgEarlyWarningDays() {
        return cgEarlyWarningDays;
    }

    public void setCgEarlyWarningDays(Integer cgEarlyWarningDays) {
        this.cgEarlyWarningDays = cgEarlyWarningDays;
    }

    public Integer getCgEarlyWarningInvalidDays() {
        return cgEarlyWarningInvalidDays;
    }

    public void setCgEarlyWarningInvalidDays(Integer cgEarlyWarningInvalidDays) {
        this.cgEarlyWarningInvalidDays = cgEarlyWarningInvalidDays;
    }

    public Integer getCgEarlyWarningDaysBeforeRetention() {
        return cgEarlyWarningDaysBeforeRetention;
    }

    public void setCgEarlyWarningDaysBeforeRetention(Integer cgEarlyWarningDaysBeforeRetention) {
        this.cgEarlyWarningDaysBeforeRetention = cgEarlyWarningDaysBeforeRetention;
    }

    public Integer getStoreEarlyWarningDays() {
        return storeEarlyWarningDays;
    }

    public void setStoreEarlyWarningDays(Integer storeEarlyWarningDays) {
        this.storeEarlyWarningDays = storeEarlyWarningDays;
    }

    public Integer getFhEarlyWarningDays() {
        return fhEarlyWarningDays;
    }

    public void setFhEarlyWarningDays(Integer fhEarlyWarningDays) {
        this.fhEarlyWarningDays = fhEarlyWarningDays;
    }

    public Integer getFhEarlyWarningInvalidDays() {
        return fhEarlyWarningInvalidDays;
    }

    public void setFhEarlyWarningInvalidDays(Integer fhEarlyWarningInvalidDays) {
        this.fhEarlyWarningInvalidDays = fhEarlyWarningInvalidDays;
    }

    public Integer getFhEarlyWarningDaysBeforeRetention() {
        return fhEarlyWarningDaysBeforeRetention;
    }

    public void setFhEarlyWarningDaysBeforeRetention(Integer fhEarlyWarningDaysBeforeRetention) {
        this.fhEarlyWarningDaysBeforeRetention = fhEarlyWarningDaysBeforeRetention;
    }

    public Integer getSyslogDaysBeforeRetention() {
        return syslogDaysBeforeRetention;
    }

    public void setSyslogDaysBeforeRetention(Integer syslogDaysBeforeRetention) {
        this.syslogDaysBeforeRetention = syslogDaysBeforeRetention;
    }

    public Integer getIsUsersLoginForbidden() {
        return isUsersLoginForbidden;
    }

    public void setIsUsersLoginForbidden(Integer isUsersLoginForbidden) {
        this.isUsersLoginForbidden = isUsersLoginForbidden;
    }

    @Override
    public String toString() {
        return "SysSetting{" +
                "id=" + id +
                ", cgEarlyWarningDays=" + cgEarlyWarningDays +
                ", cgEarlyWarningInvalidDays=" + cgEarlyWarningInvalidDays +
                ", cgEarlyWarningDaysBeforeRetention=" + cgEarlyWarningDaysBeforeRetention +
                ", storeEarlyWarningDays=" + storeEarlyWarningDays +
                ", fhEarlyWarningDays=" + fhEarlyWarningDays +
                ", fhEarlyWarningInvalidDays=" + fhEarlyWarningInvalidDays +
                ", fhEarlyWarningDaysBeforeRetention=" + fhEarlyWarningDaysBeforeRetention +
                ", syslogDaysBeforeRetention=" + syslogDaysBeforeRetention +
                ", isUsersLoginForbidden=" + isUsersLoginForbidden +
                '}';
    }
}
