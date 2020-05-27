package cn.cuit.gyl.service.system.impl;

import cn.cuit.gyl.dao.system.ISysLogDao;
import cn.cuit.gyl.domain.system.SysLog;
import cn.cuit.gyl.service.system.ISysLogService;
import cn.cuit.gyl.utils.ConverterUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("sysLogServiceImpl")
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    @Qualifier("iSysLogDao")
    private ISysLogDao iSysLogDao = null;

    @Override
    public void save(SysLog sysLog) throws Exception {
        iSysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAllBySysLogOrTime(SysLog sysLog, Date startTime, Date endTime, Integer pageNum, Integer pageSize) throws Exception{
        List<SysLog> sysLogs = null;
        if(sysLog != null){
            PageHelper.startPage(pageNum, pageSize);
            sysLogs = iSysLogDao.findBySysLog(sysLog);
        }else if(startTime!=null && endTime!=null){
            Date newStartTime = ConverterUtils.stringToDate(ConverterUtils.dateToString(startTime,"yyyy-MM-dd HH:mm")+":00", "yyyy-MM-dd HH:mm:ss");
            Date newEndTime = ConverterUtils.stringToDate(ConverterUtils.dateToString(endTime,"yyyy-MM-dd HH:mm")+":00", "yyyy-MM-dd HH:mm:ss");
            PageHelper.startPage(pageNum, pageSize);
            sysLogs = iSysLogDao.findAllBetweenStartAndEndTimeOrderByTimeDesc(newStartTime,newEndTime);
        }else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String todayStr = simpleDateFormat.format(new Date());
            String startTimeStr = todayStr+" 00:00:00";
            String endTimeStr = todayStr+" 23:59:59";
            Date newStartTime = ConverterUtils.stringToDate(startTimeStr, "yyyy-MM-dd HH:mm:ss");
            Date newendTime = ConverterUtils.stringToDate(endTimeStr, "yyyy-MM-dd HH:mm:ss");
            PageHelper.startPage(pageNum, pageSize);
            sysLogs = iSysLogDao.findAllBetweenStartAndEndTimeOrderByTimeDesc(newStartTime,newendTime);
        }
        return sysLogs;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        iSysLogDao.deleteById(id);
    }

    @Override
    public void deleteByIds(Long[] ids) throws Exception {
        for (Long id:ids) {
            if(id != null){
                iSysLogDao.deleteById(id);
            }
        }
    }
}
