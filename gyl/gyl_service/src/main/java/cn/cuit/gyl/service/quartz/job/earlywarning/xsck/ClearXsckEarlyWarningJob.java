package cn.cuit.gyl.service.quartz.job.earlywarning.xsck;

import cn.cuit.gyl.dao.business.IEarlyWarning_XsckDao;
import cn.cuit.gyl.dao.system.ISysSettingDao;
import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
import cn.cuit.gyl.utils.SpringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//定期清除状态为没有预警的销售出库预警信息
public class ClearXsckEarlyWarningJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            //System.out.println("ClearXsckEarlyWarningJob执行了...");
            ISysSettingDao iSysSettingDao = (ISysSettingDao)SpringUtils.getBean("iSysSettingDao");//系统设置dao
            IEarlyWarning_XsckDao iEarlyWarning_xsckDao= (IEarlyWarning_XsckDao)SpringUtils.getBean("iEarlyWarning_XsckDao");//销售出库预警表dao

            List<EarlyWarning_Xsck> earlyWarning_xscks = iEarlyWarning_xsckDao.findAllWhereStatusIsFalse();//查询所有status=0的销售出库预警s
            if(earlyWarning_xscks!=null && earlyWarning_xscks.size() > 0){
                Integer fhEarlyWarningDaysBeforeRetention = iSysSettingDao.findFhEarlyWarningDaysBeforeRetentionById(1);//保留没有预警且在保留天数之内的数据项
                Iterator<EarlyWarning_Xsck> iterator = earlyWarning_xscks.iterator();
                while (iterator.hasNext()){
                    EarlyWarning_Xsck earlyWarning_xsck = iterator.next();
                    Date today = new Date();
                    Date yqfhrq = earlyWarning_xsck.getYqfhrq();
                    if(today.after(yqfhrq)){//证明：要求出库日期已经过了
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(yqfhrq);
                        calendar.add(Calendar.DATE,fhEarlyWarningDaysBeforeRetention);//删除的临界时间：今天超过临界时间则删除信息
                        if(today.after(calendar.getTime())){
                            iEarlyWarning_xsckDao.deleteById(earlyWarning_xsck.getId());//清除信息
                            //System.out.println("删除信息："+earlyWarning_xsck);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DATE, -1);
        System.out.println(date.after(instance.getTime()));
    }
}
