package cn.cuit.gyl.service.quartz.job;

import cn.cuit.gyl.utils.ConverterUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 第二种，作业类不继承特定基类
 */
public class Job1 implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job1执行了，时间："+ ConverterUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }
}
