package cn.cuit.gyl.service.system;

import cn.cuit.gyl.domain.system.SysSetting;

public interface ISysSettingService {

    //查询系统设置
    SysSetting findSysSettingById(Integer id) throws Exception;

    void UpdateCgEarlyWarningDays(Integer val) throws Exception;

    void UpdateCgEarlyWarningInvalidDays(Integer val) throws Exception;

    void UpdateCgEarlyWarningDaysBeforeRetention(Integer val) throws Exception;

    void UpdateStoreEarlyWarningDays(Integer val) throws Exception;

    void UpdateFhEarlyWarningDays(Integer val) throws Exception;

    void UpdateFhEarlyWarningInvalidDays(Integer val) throws Exception;

    void UpdateFhEarlyWarningDaysBeforeRetention(Integer val) throws Exception;

    void UpdateSyslogDaysBeforeRetention(Integer val) throws Exception;

    void UpdateIsUsersLoginForbidden(Integer isUsersLoginForbidden) throws Exception;
}
