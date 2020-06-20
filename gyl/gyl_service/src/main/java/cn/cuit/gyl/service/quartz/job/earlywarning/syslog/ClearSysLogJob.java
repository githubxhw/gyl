package cn.cuit.gyl.service.quartz.job.earlywarning.syslog;

import cn.cuit.gyl.dao.system.ISysLogDao;
import cn.cuit.gyl.dao.system.ISysSettingDao;
import cn.cuit.gyl.utils.SpringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;
import java.util.Date;

public class ClearSysLogJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            //System.out.println("ClearSysLogJob执行...");
            ISysLogDao iSysLogDao = (ISysLogDao)SpringUtils.getBean("iSysLogDao");//系统日志的dao
            ISysSettingDao iSysSettingDao = (ISysSettingDao) SpringUtils.getBean("iSysSettingDao");//系统设置dao

            Integer syslogDaysBeforeRetention = iSysSettingDao.findSyslogDaysBeforeRetentionById(1);//保留天数
            Date today = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(today);
            calendar.add(Calendar.DATE,-syslogDaysBeforeRetention);//前syslogDaysBeforeRetention天的时间临界值
            //System.out.println("calendar:"+calendar.getTime());
            iSysLogDao.deleteWhereVisit_timeBeforDate(calendar.getTime());//删除所有visit_time before 临界值的日志
            //System.out.println("日志清除成功...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
