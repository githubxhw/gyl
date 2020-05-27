package cn.cuit.gyl.service.quartz.job;

import cn.cuit.gyl.utils.ConverterUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class Job2 implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("job2执行了，时间："+ ConverterUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }
}
