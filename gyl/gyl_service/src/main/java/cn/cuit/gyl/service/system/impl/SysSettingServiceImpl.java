package cn.cuit.gyl.service.system.impl;

import cn.cuit.gyl.dao.business.IEarlyWarning_StoreDao;
import cn.cuit.gyl.dao.database.IUserDao;
import cn.cuit.gyl.dao.privilege.IPermissionDao;
import cn.cuit.gyl.dao.privilege.IRoleDao;
import cn.cuit.gyl.dao.system.ISysSettingDao;
import cn.cuit.gyl.domain.business.EarlyWarning_Store;
import cn.cuit.gyl.domain.database.UserInfo;
import cn.cuit.gyl.domain.privilege.Role;
import cn.cuit.gyl.domain.system.SysSetting;
import cn.cuit.gyl.service.system.ISysSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Service("sysSettingServiceImpl")
public class SysSettingServiceImpl implements ISysSettingService {

    @Autowired
    @Qualifier("iSysSettingDao")
    private ISysSettingDao iSysSettingDao = null;

    @Autowired
    @Qualifier("iEarlyWarning_StoreDao")
    private IEarlyWarning_StoreDao iEarlyWarning_storeDao = null;

    @Autowired
    @Qualifier("iUserDao")
    private IUserDao iUserDao = null;

    @Autowired
    @Qualifier("iRoleDao")
    private IRoleDao iRoleDao = null;

    @Autowired
    @Qualifier("iPermissionDao")
    private IPermissionDao iPermissionDao = null;

    @Override
    public SysSetting findSysSettingById(Integer id) throws Exception {
        return iSysSettingDao.findById(id);
    }

    @Override
    public void UpdateCgEarlyWarningDays(Integer val) throws Exception {
        iSysSettingDao.UpdateCgEarlyWarningDays(val);
    }

    @Override
    public void UpdateCgEarlyWarningInvalidDays(Integer val) throws Exception {
        iSysSettingDao.UpdateCgEarlyWarningInvalidDays(val);
    }

    @Override
    public void UpdateCgEarlyWarningDaysBeforeRetention(Integer val) throws Exception {
        iSysSettingDao.UpdateCgEarlyWarningDaysBeforeRetention(val);
    }

    @Override
    public void UpdateStoreEarlyWarningDays(Integer val) throws Exception {
        iSysSettingDao.UpdateStoreEarlyWarningDays(val);
        List<EarlyWarning_Store> all = iEarlyWarning_storeDao.findAll();
        if(all!=null && all.size()>0){
            Iterator<EarlyWarning_Store> iterator = all.iterator();
            while (iterator.hasNext()){
                EarlyWarning_Store next = iterator.next();
                Integer checkExp = next.getCheckExp();
                if(checkExp != null && !val.equals(checkExp)){
                    next.setCheckExp(val);
                    iEarlyWarning_storeDao.updateById(next);
                }
            }
        }
    }

    @Override
    public void UpdateFhEarlyWarningDays(Integer val) throws Exception {
        iSysSettingDao.UpdateFhEarlyWarningDays(val);
    }

    @Override
    public void UpdateFhEarlyWarningInvalidDays(Integer val) throws Exception {
        iSysSettingDao.UpdateFhEarlyWarningInvalidDays(val);
    }

    @Override
    public void UpdateFhEarlyWarningDaysBeforeRetention(Integer val) throws Exception {
        iSysSettingDao.UpdateFhEarlyWarningDaysBeforeRetention(val);
    }

    @Override
    public void UpdateSyslogDaysBeforeRetention(Integer val) throws Exception {
        iSysSettingDao.UpdateSyslogDaysBeforeRetention(val);
    }

    @Override
    public void UpdateIsUsersLoginForbidden(Integer isUsersLoginForbidden) throws Exception {
        if(isUsersLoginForbidden.equals(1)){//阻止
            Integer id = iPermissionDao.findIdByPermissionName("UI_XTGL_SYSSETTING");
            List<Role> roles = iRoleDao.findByPermissionId(id);
            List<UserInfo> userInfos = new ArrayList<>();
            if (roles!=null && roles.size() > 0){
                for (Role role:roles){
                    List<UserInfo> users = iUserDao.findByRoleId(role.getId());
                    if(users!=null && users.size()>0){
                        userInfos.addAll(users);
                    }
                }
            }
            HashSet<UserInfo> hashSet = new HashSet<>(userInfos);//这个里面的有系统设置权限的所有用户
            iUserDao.setAllStatusFalse();//设置所有的用户的status为0
            if(hashSet!=null && hashSet.size()>0){
                for (UserInfo userInfo:hashSet) {
                    //System.out.println("userInfo："+userInfo);
                    iUserDao.setStatusTrueById(userInfo.getId());//设置用户的status为true
                }
            }
        }else {//不阻止
            iUserDao.setAllStatusTrue();//设置所有的用户的status为1
        }
    }

}
