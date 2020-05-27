package cn.cuit.gyl.service.system.impl;

import cn.cuit.gyl.dao.system.IJobDao;
import cn.cuit.gyl.domain.system.Job;
import cn.cuit.gyl.service.quartz.QuartzManager;
import cn.cuit.gyl.service.system.IJobService;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringConverterUtils;
import com.github.pagehelper.PageHelper;
import org.quartz.CronExpression;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("jobServiceImpl")
public class JobServiceImpl implements IJobService {

    @Autowired
    @Qualifier("quartzManager")
    private QuartzManager quartzManager = null;

    @Autowired
    @Qualifier("iJobDao")
    private IJobDao iJobDao = null;

    @Override
    public List<Job> findAllByPage(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return iJobDao.findAll();
    }

    @Override
    public List<Job> findJobByJobName(Integer pageNum, Integer pageSize,String jobName) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Job> jobs = new ArrayList();
        Job job = iJobDao.findByJobName(jobName);
        jobs.add(job);
        return jobs;
    }

    @Override
    public Job findJobByJobId(Long jobId) throws Exception {
        return iJobDao.findByJobId(jobId);
    }

    @Override
    public PageInfo updateJobByJobId(Job job) throws Exception {
        //System.out.println(job);
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();
        //1，判断job （jobName，jobGroupName）是否重复
        int count = 0;//count < 0，则pageInfo.setResFlag = 0失败；
        Job job1 = iJobDao.findByJobNameAndJobGroupNameNotEqJobId(job.getJobName(),job.getJobGroupName(),job.getJobId());
        if(job1 != null){
            count--;
            msgList.add("任务名和任务组已存在;");
        }
        //2，判断job 的任务实现全限定类名jobClassName是否存在,且是否有excute方法
        try {
            Class clazz = Class.forName(job.getJobClassName());
            clazz.getMethod("execute", JobExecutionContext.class);
        } catch (ClassNotFoundException e1) {
            count--;
            msgList.add("任务实现类没有找到;");
        }catch (NoSuchMethodException e2){
            count--;
            msgList.add("实现类存在，但没有找到excute方法;");
        }
        //3，判断job  （triggerName，triggerGroupName）是否重复
        Job job2 = iJobDao.findByTriggerNameAndTriggerGroupNameNotEqJobId(job.getTriggerName(),job.getTriggerGroupName(),job.getJobId());
        if(job2 != null){
            count--;
            msgList.add("触发器名和触发器组已存在;");
        }
        //4，判断job 的cronExpression是否正确
        job.setCronExpression(job.getCronExpression().trim());
        boolean matches = CronExpression.isValidExpression(job.getCronExpression());//用的是quartz里面jar中的方法，也可以使用正则表达式，但是太麻烦，不推荐
        if(matches == false){
            count--;
            msgList.add("cron表达式不正确;");
        }
        if(count < 0){
            pageInfo.setResFlag("0");
            return pageInfo;
        }else {
            pageInfo.setResFlag("1");
            job.setUpdateTime(new Date());
            iJobDao.updateByJobId(job);
            if (job.getJobStatus() == 1){//在任务调度器中
                quartzManager.modifyJobTime(job.getJobName(), job.getJobGroupName(), job.getTriggerName(), job.getTriggerGroupName(), job.getCronExpression());
            }
            return pageInfo;
        }
    }

    @Override
    public void openServerInJobId(Long jobId) throws Exception {
        Job job = iJobDao.findByJobId(jobId);
        if(job!=null){
            if(job.getJobStatus() == 0){
                job.setJobStatus(1);
                iJobDao.updateByJobId(job);
            }
            quartzManager.addJob(job.getJobName(),job.getJobGroupName(),Class.forName(job.getJobClassName()),job.getTriggerName(),job.getTriggerGroupName(),job.getCronExpression());
        }else {
            throw new RuntimeException("当jobId="+jobId+"时，job为null");
        }
    }

    @Override
    public void closeServerInJobId(Long jobId) throws Exception {
        Job job = iJobDao.findByJobId(jobId);
        if(job!=null){
            if(job.getJobStatus() == 1){
                job.setJobStatus(0);
                iJobDao.updateByJobId(job);
            }
            quartzManager.removeJob(job.getJobName(),job.getJobGroupName(),job.getTriggerName(), job.getTriggerGroupName());
        }else {
            throw new RuntimeException("当jobId="+jobId+"时，job为null");
        }
    }

    @Override
    public Long getJobIdToAddModal() throws Exception {
        Long maxJobId = iJobDao.findMaxJobId();
        if(maxJobId == null){
            return 1L;
        }
        return maxJobId+1;
    }

    @Override
    public PageInfo addJob(Job job) throws Exception {
        System.out.println(job);
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();

        //1，判断job （jobName，jobGroupName）是否重复
        int count = 0;//count < 0，则pageInfo.setResFlag = 0失败；
        Job job1 = iJobDao.findByJobNameAndJobGroupNameNotEqJobId(job.getJobName(),job.getJobGroupName(),job.getJobId());
        if(job1 != null){
            count--;
            msgList.add("任务名和任务组已存在;");
        }
        //2，判断job 的任务实现全限定类名jobClassName是否存在,且是否有excute方法
        try {
            Class clazz = Class.forName(job.getJobClassName());
            clazz.getMethod("execute", JobExecutionContext.class);
        } catch (ClassNotFoundException e1) {
            count--;
            msgList.add("任务实现类没有找到;");
        }catch (NoSuchMethodException e2){
            count--;
            msgList.add("实现类存在，但没有找到excute方法;");
        }
        //3，判断job  （triggerName，triggerGroupName）是否重复
        Job job2 = iJobDao.findByTriggerNameAndTriggerGroupNameNotEqJobId(job.getTriggerName(),job.getTriggerGroupName(),job.getJobId());
        if(job2 != null){
            count--;
            msgList.add("触发器名和触发器组已存在;");
        }
        //4，判断job 的cronExpression是否正确
        job.setCronExpression(job.getCronExpression().trim());
        boolean matches = CronExpression.isValidExpression(job.getCronExpression());//用的是quartz里面jar中的方法，也可以使用正则表达式，但是太麻烦，不推荐
        if(matches == false){
            count--;
            msgList.add("cron表达式不正确;");
        }

        if(count < 0){//job信息有问题
            pageInfo.setResFlag("0");
        }else {//job信息没有问题
            pageInfo.setResFlag("1");
            job.setCreateTime(new Date());//设置添加时间
            iJobDao.addHasJobId(job);
        }
        return pageInfo;
    }

    @Override
    public PageInfo deleteJobs(String ids) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();

        Long[] IDS = StringConverterUtils.convertToLong(ids, ",");
        int count = 0;
        if(IDS!=null){
            for (Long id:IDS) {
                Job job = iJobDao.findByJobId(id);
                if(job.getJobStatus() == 1){
                    count--;
                    msgList.add("ID为："+id+"的任务正在执行;");
                }
            }
        }
        if(count == 0){//表示没有任务在运行
            if(IDS!=null){
                for (Long id:IDS) {
                    iJobDao.deleteByJobId(id);//删除任务
                }
            }
            pageInfo.setResFlag("1");
        }else {
            pageInfo.setResFlag("0");
        }
        return pageInfo;
    }
}
