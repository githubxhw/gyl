package cn.cuit.gyl.controller.system;

import cn.cuit.gyl.domain.system.SysSetting;
import cn.cuit.gyl.service.system.ISysSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sysSetting")
public class SysSettingController {

    @Autowired
    @Qualifier("sysSettingServiceImpl")
    private ISysSettingService iSysSettingService = null;

    //查询系统设置
    @RequestMapping("/findSysSettingById")
    @ResponseBody
    public SysSetting findSysSettingById(Integer id) throws Exception{
        SysSetting sysSetting = iSysSettingService.findSysSettingById(id);
        return sysSetting;
    }

    //UpdateCgEarlyWarningDays 2
    @RequestMapping("/UpdateCgEarlyWarningDays")
    @ResponseBody
    public void UpdateCgEarlyWarningDays(Integer val) throws Exception{
        iSysSettingService.UpdateCgEarlyWarningDays(val);
        return;
    }

    //UpdateCgEarlyWarningInvalidDays 3
    @RequestMapping("/UpdateCgEarlyWarningInvalidDays")
    @ResponseBody
    public void UpdateCgEarlyWarningInvalidDays(Integer val) throws Exception{
        iSysSettingService.UpdateCgEarlyWarningInvalidDays(val);
        return;
    }

    //UpdateCgEarlyWarningDaysBeforeRetention 4
    @RequestMapping("/UpdateCgEarlyWarningDaysBeforeRetention")
    @ResponseBody
    public void UpdateCgEarlyWarningDaysBeforeRetention(Integer val) throws Exception{
        iSysSettingService.UpdateCgEarlyWarningDaysBeforeRetention(val);
        return;
    }

    //UpdateStoreEarlyWarningDays 5 ////////
    @RequestMapping("/UpdateStoreEarlyWarningDays")
    @ResponseBody
    public void UpdateStoreEarlyWarningDays(Integer val) throws Exception{
        iSysSettingService.UpdateStoreEarlyWarningDays(val);
        return;
    }

    //UpdateFhEarlyWarningDays 6
    @RequestMapping("/UpdateFhEarlyWarningDays")
    @ResponseBody
    public void UpdateFhEarlyWarningDays(Integer val) throws Exception{
        iSysSettingService.UpdateFhEarlyWarningDays(val);
        return;
    }

    //UpdateFhEarlyWarningInvalidDays 7
    @RequestMapping("/UpdateFhEarlyWarningInvalidDays")
    @ResponseBody
    public void UpdateFhEarlyWarningInvalidDays(Integer val) throws Exception{
        iSysSettingService.UpdateFhEarlyWarningInvalidDays(val);
        return;
    }

    //UpdateFhEarlyWarningDaysBeforeRetention 8
    @RequestMapping("/UpdateFhEarlyWarningDaysBeforeRetention")
    @ResponseBody
    public void UpdateFhEarlyWarningDaysBeforeRetention(Integer val) throws Exception{
        iSysSettingService.UpdateFhEarlyWarningDaysBeforeRetention(val);
        return;
    }

    //UpdateSyslogDaysBeforeRetention 9
    @RequestMapping("/UpdateSyslogDaysBeforeRetention")
    @ResponseBody
    public void UpdateSyslogDaysBeforeRetention(Integer val) throws Exception{
        iSysSettingService.UpdateSyslogDaysBeforeRetention(val);
        return;
    }

    //UpdateIsUsersLoginForbidden 10
    @RequestMapping("/UpdateIsUsersLoginForbidden")
    @ResponseBody
    public void UpdateIsUsersLoginForbidden(Integer isUsersLoginForbidden) throws Exception{
        iSysSettingService.UpdateIsUsersLoginForbidden(isUsersLoginForbidden);
        return;
    }
}
