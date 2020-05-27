package cn.cuit.gyl.dao.system;

import cn.cuit.gyl.domain.system.Job;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iJobDao")
public interface IJobDao {

    //查询所有的任务s
    @Select("select * from job")
    List<Job> findAll() throws Exception;

    //根据任务名称查询信息
    @Select("select * from job where jobName=#{jobName}")
    Job findByJobName(String jobName) throws Exception;

    //根据job任务id查询信息
    @Select("select * from job where jobId=#{jobId}")
    Job findByJobId(Long jobId) throws Exception;

    //根据id更新job消息
    @Update("update job set " +
            "jobName=#{jobName},jobGroupName=#{jobGroupName},jobClassName=#{jobClassName}," +
            "triggerName=#{triggerName},triggerGroupName=#{triggerGroupName},cronExpression=#{cronExpression}," +
            "createTime=#{createTime},updateTime=#{updateTime},jobStatus=#{jobStatus},description=#{description} where jobId=#{jobId}")
    void updateByJobId(Job job) throws Exception;

    //根据任务名称和任务组名称查询信息
    @Select("select * from job where jobName=#{jobName} and jobGroupName=#{jobGroupName}")
    Job findByJobNameAndJobGroupName(@Param("jobName") String jobName,@Param("jobGroupName") String jobGroupName) throws Exception;

    //根据触发器名称和触发器组名称查询信息
    @Select("select * from job where triggerName=#{triggerName} and triggerGroupName=#{triggerGroupName}")
    Job findByTriggerNameAndTriggerGroupName(@Param("triggerName") String triggerName,@Param("triggerGroupName") String triggerGroupName) throws Exception;

    //在不等于所给的jobId的情况下，根据任务名称和任务组名称查询信息
    @Select("select * from job where jobName=#{jobName} and jobGroupName=#{jobGroupName} and jobId != #{jobId}")
    Job findByJobNameAndJobGroupNameNotEqJobId(@Param("jobName") String jobName,@Param("jobGroupName") String jobGroupName,@Param("jobId") Long jobId) throws Exception;

    //在不等于所给的jobId的情况下，根据触发器名称和触发器组名称查询信息
    @Select("select * from job where triggerName=#{triggerName} and triggerGroupName=#{triggerGroupName} and jobId != #{jobId}")
    Job findByTriggerNameAndTriggerGroupNameNotEqJobId(@Param("triggerName") String triggerName,@Param("triggerGroupName") String triggerGroupName,@Param("jobId") Long jobId) throws Exception;

    //查询最大的任务id
    @Select("select MAX(`jobId`) from job")
    Long findMaxJobId() throws Exception;

    //添加一条job信息(没有jobId)
    @Insert("insert into job " +
            "(jobName,jobGroupName,jobClassName,triggerName,triggerGroupName,cronExpression,createTime,updateTime,jobStatus,description) " +
            "values " +
            "(#{jobName},#{jobGroupName},#{jobClassName},#{triggerName},#{triggerGroupName},#{cronExpression},#{createTime},#{updateTime},#{jobStatus},#{description})")
    void add(Job job) throws Exception;

    //添加一条job信息（有jobId）
    @Insert("insert into job " +
            "(jobId,jobName,jobGroupName,jobClassName,triggerName,triggerGroupName,cronExpression,createTime,updateTime,jobStatus,description) " +
            "values " +
            "(#{jobId},#{jobName},#{jobGroupName},#{jobClassName},#{triggerName},#{triggerGroupName},#{cronExpression},#{createTime},#{updateTime},#{jobStatus},#{description})")
    void addHasJobId(Job job) throws Exception;

    //删除一条任务
    @Delete("delete from job where jobId=#{jobId}")
    void deleteByJobId(Long jobId) throws Exception;
}
