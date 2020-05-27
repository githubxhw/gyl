package cn.cuit.gyl.service.quartz;

import cn.cuit.gyl.dao.system.IJobDao;
import cn.cuit.gyl.domain.system.Job;
import cn.cuit.gyl.utils.ConverterUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;

/**
 * 该类用于任务调度容器的管理manager程序
 */
public class QuartzManager {

    @Autowired
    @Qualifier("iJobDao")
    private IJobDao iJobDao = null;

    //容器，用get,set注入
    private Scheduler scheduler;

    /*Class.forName(cron.getCronClass()).newInstance()*/

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * @Description:添加一条任务执行
     *
     * @param jobName 任务名称
     * @param jobGroupName 任务组名称
     * @param jobClass 任务实现全限定类
     * @param triggerName 触发器名称
     * @param triggerGroupName 触发器组名称
     * @param cronExpression cron表达式
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addJob(String jobName,String jobGroupName,Class jobClass,String triggerName,String triggerGroupName,String cronExpression){
        try {
            //任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            //触发器，触发器名称，触发器组名称
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
            //创建Trigger对象
            Trigger trigger = triggerBuilder.build();
            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);

            //启动:可以手动打开任务调度器
            /*if(!scheduler.isShutdown()){
                scheduler.start();
            }*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return;
    }

    /**
     * @Description:修改指定任务的执行时间
     *
     * @param jobName 任务名称
     * @param jobGroupName 任务组名称
     * @param triggerName 触发器名称
     * @param triggerGroupName 触发器组名称
     * @param newCronExpression 新cron表达式
     */
    public void modifyJobTime(String jobName,String jobGroupName,String triggerName,String triggerGroupName,String newCronExpression){
        try{
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,triggerGroupName);
            CronTrigger trigger = (CronTrigger)scheduler.getTrigger(triggerKey);
            if(trigger == null){
                System.out.println("没有找到指定的触发器");
                return;
            }

            String oldCronExpression = trigger.getCronExpression();
            if(!oldCronExpression.equals(newCronExpression)){//表达式不相同则修改
                /*方式一：调用 rescheduleJob 覆盖*/
                //触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                //触发器名,触发器组
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                triggerBuilder.startNow();
                //触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(newCronExpression));
                //创建Trigger对象
                trigger = (CronTrigger) triggerBuilder.build();
                //修改一个任务的触发时间
                scheduler.rescheduleJob(triggerKey, trigger);
                /*方式二：先删除，然后在创建一个新的Job*/
                //JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
                //Class<? extends Job> jobClass = jobDetail.getJobClass();
                //removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
                //addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:移除一个任务
     *
     * @param jobName 任务名称
     * @param jobGroupName 任务组名称
     * @param triggerName 触发器名称
     * @param triggerGroupName 触发器组名称
     */
    public void removeJob(String jobName,String jobGroupName,String triggerName,String triggerGroupName){
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            scheduler.pauseTrigger(triggerKey);//停止触发器
            scheduler.unscheduleJob(triggerKey);//移除触发器
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));//删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:初始化
     * 把job添加到任务调度器中
     */
    public void init() {
        try {
            scheduler.clear();
            List<Job> jobs = iJobDao.findAll();//所有的任务
            if(jobs!=null){
                for (Job job:jobs) {
                    if(job.getJobStatus() == 1){//在服务状态，添加到任务调度器
                        //在job中消息没有问题的情况下
                        addJob(job.getJobName(),job.getJobGroupName(),Class.forName(job.getJobClassName()),job.getTriggerName(),job.getTriggerGroupName(),job.getCronExpression());
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:启动所有定时任务
     */
    public void startJobs() {
        try {
            System.out.println("正在启动任务调度器...");
            scheduler.start();
            System.out.println("启动成功，时间："+ ConverterUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:暂停所有定时任务
     */
    public void standByJobs() {
        try {
            System.out.println("正在暂停任务调度器...");
            scheduler.standby();
            System.out.println("暂停成功，时间："+ ConverterUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:关闭所有定时任务
     */
    public void shutdownJobs() {
        try {
            if (!scheduler.isShutdown()) {
                System.out.println("正在关闭任务调度器...");
                scheduler.shutdown();
                System.out.println("关闭成功，时间："+ ConverterUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:判断任务调度器是否启动
     * @return true or false
     */
    public boolean isStarted(){
        try {
            return scheduler.isStarted();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:判断任务调度器是否暂停
     * @return true or false
     */
    public boolean isInStandbyMode(){
        try {
            return scheduler.isInStandbyMode();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:是否是单例
     * @return true
     */
    public boolean isSingle(){
        return true;
    }


}
