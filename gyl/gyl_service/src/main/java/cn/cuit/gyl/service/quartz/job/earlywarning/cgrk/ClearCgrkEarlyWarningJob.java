package cn.cuit.gyl.service.quartz.job.earlywarning.cgrk;

import cn.cuit.gyl.dao.business.IEarlyWarning_CgrkDao;
import cn.cuit.gyl.dao.system.ISysSettingDao;
import cn.cuit.gyl.domain.business.EarlyWarning_Cgrk;
import cn.cuit.gyl.utils.SpringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//定期清除状态为没有预警的采购入库预警信息
public class ClearCgrkEarlyWarningJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            //System.out.println("ClearCgrkEarlyWarningJob执行了...");
            ISysSettingDao iSysSettingDao = (ISysSettingDao)SpringUtils.getBean("iSysSettingDao");//系统设置dao
            IEarlyWarning_CgrkDao iEarlyWarning_cgrkDao = (IEarlyWarning_CgrkDao)SpringUtils.getBean("IEarlyWarning_CgrkDao");//采购入库预警表的dao

            List<EarlyWarning_Cgrk> earlyWarning_cgrks = iEarlyWarning_cgrkDao.findAllWhereStatusIsFalse();//查询所有status=0的采购入库预警s
            if(earlyWarning_cgrks != null && earlyWarning_cgrks.size() > 0){
                Integer cgEarlyWarningDaysBeforeRetention = iSysSettingDao.findCgEarlyWarningDaysBeforeRetentionById(1);
                Iterator<EarlyWarning_Cgrk> iterator = earlyWarning_cgrks.iterator();
                while (iterator.hasNext()){
                    EarlyWarning_Cgrk earlyWarning_cgrk = iterator.next();
                    Date today = new Date();
                    Date yqdhrq = earlyWarning_cgrk.getYqdhrq();
                    if(today.after(yqdhrq)){//证明：要求入库日期已经过了
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(yqdhrq);
                        calendar.add(Calendar.DATE, cgEarlyWarningDaysBeforeRetention);
                        if(today.after(calendar.getTime())){//删除的临界时间：今天超过临界时间则删除信息
                            iEarlyWarning_cgrkDao.deleteById(earlyWarning_cgrk.getId());//删除信息
                            //System.out.println("删除信息："+earlyWarning_cgrk);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
