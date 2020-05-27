package cn.cuit.gyl.service.system;

import cn.cuit.gyl.domain.system.Job;
import cn.cuit.gyl.utils.PageInfo;

import java.util.List;

public interface IJobService {

    //分页查询所有的任务jobs
    List<Job> findAllByPage(Integer pageNum, Integer pageSize) throws Exception;

    //根据任务名称查询任务信息
    List<Job> findJobByJobName(Integer pageNum, Integer pageSize,String jobName) throws Exception;

    //根据任务id查询信息
    Job findJobByJobId(Long jobId) throws Exception;

    //根据任务id修改任务信息
    //判读job是否在服务:若在服务，则更新任务调度器服务；
    PageInfo updateJobByJobId(Job job) throws Exception;

    //开启当前job（根据jobId查询）服务程序
    void openServerInJobId(Long jobId) throws Exception;

    //关闭当前job（根据jobId查询）服务程序
    void closeServerInJobId(Long jobId) throws Exception;

    //获取job的id到页面:查询最大jobId+1
    Long getJobIdToAddModal() throws Exception;

    //添加一条job信息，并返回添加情况信息
    PageInfo addJob(Job job) throws Exception;

    //根据ids删除jobs
    PageInfo deleteJobs(String ids) throws Exception;
}
