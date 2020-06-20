package cn.cuit.gyl.dao.system;

import cn.cuit.gyl.domain.system.SysSetting;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository("iSysSettingDao")
public interface ISysSettingDao {

    //根据id查询系统设置
    @Select("select * from system_setting where id=#{id}")
    SysSetting findById(Integer id) throws Exception;

    //根据id查询：采购入库提前预警天数
    @Select("select `cgEarlyWarningDays` from system_setting where id=#{id}")
    Integer findCgEarlyWarningDaysById(Integer id) throws Exception;

    //根据id查询：采购入库日期失效后的连续预警天数
    @Select("select `cgEarlyWarningInvalidDays` from system_setting where id=#{id}")
    Integer findCgEarlyWarningInvalidDaysById(Integer id) throws Exception;

    //根据id查询：保留采购没有预警且在保留天数之内的数据项
    @Select("select `cgEarlyWarningDaysBeforeRetention` from system_setting where id=#{id}")
    Integer findCgEarlyWarningDaysBeforeRetentionById(Integer id) throws Exception;

    //根据id查询：仓库提前预警天数
    @Select("select `storeEarlyWarningDays` from system_setting where id=#{id}")
    Integer findStoreEarlyWarningDaysById(Integer id) throws Exception;

    //根据id查询：销售出库提前预警天数
    @Select("select `fhEarlyWarningDays` from system_setting where id=#{id}")
    Integer findFhEarlyWarningDaysById(Integer id) throws Exception;

    //根据id查询：销售出库日期失效后的连续预警天数
    @Select("select `fhEarlyWarningInvalidDays` from system_setting where id=#{id}")
    Integer findFhEarlyWarningInvalidDaysById(Integer id) throws Exception;

    //根据id查询：保留销售没有预警且在保留天数之内的数据项
    @Select("select `fhEarlyWarningDaysBeforeRetention` from system_setting where id=#{id}")
    Integer findFhEarlyWarningDaysBeforeRetentionById(Integer id) throws Exception;

    //根据id查询：保留前几天的日志天数
    @Select("select `syslogDaysBeforeRetention` from system_setting where id=#{id}")
    Integer findSyslogDaysBeforeRetentionById(Integer id) throws Exception;

    //根据id查询：是否禁止所有用户登录（除了拥有系统设置的用户）1是 0否
    @Select("select `isUsersLoginForbidden` from system_setting where id=#{id}")
    Integer findIsUsersLoginForbiddenById(Integer id) throws Exception;

    @Update("update system_setting set `cgEarlyWarningDays`=#{val} where id=1")
    void UpdateCgEarlyWarningDays(Integer val) throws Exception;

    @Update("update system_setting set `cgEarlyWarningInvalidDays`=#{val} where id=1")
    void UpdateCgEarlyWarningInvalidDays(Integer val) throws Exception;

    @Update("update system_setting set `cgEarlyWarningDaysBeforeRetention`=#{val} where id=1")
    void UpdateCgEarlyWarningDaysBeforeRetention(Integer val) throws Exception;

    @Update("update system_setting set `storeEarlyWarningDays`=#{val} where id=1")
    void UpdateStoreEarlyWarningDays(Integer val) throws Exception;

    @Update("update system_setting set `fhEarlyWarningDays`=#{val} where id=1")
    void UpdateFhEarlyWarningDays(Integer val) throws Exception;

    @Update("update system_setting set `fhEarlyWarningInvalidDays`=#{val} where id=1")
    void UpdateFhEarlyWarningInvalidDays(Integer val) throws Exception;

    @Update("update system_setting set `fhEarlyWarningDaysBeforeRetention`=#{val} where id=1")
    void UpdateFhEarlyWarningDaysBeforeRetention(Integer val) throws Exception;

    @Update("update system_setting set `syslogDaysBeforeRetention`=#{val} where id=1")
    void UpdateSyslogDaysBeforeRetention(Integer val) throws Exception;
}
