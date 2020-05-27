package cn.cuit.gyl.domain.system;

import cn.cuit.gyl.utils.ConverterUtils;

import java.io.Serializable;
import java.util.Date;

//该类是任务job的domain
public class Job implements Serializable {

    private Long jobId;//任务id
    private String jobName;//任务名称
    private String jobGroupName;//任务组名称
    private String jobClassName;//任务实现全限定类名
    private String triggerName;//触发器名称
    private String triggerGroupName;//触发器组名称
    private String cronExpression;//cron表达式
    private Date createTime;//创建该任务时间
    private String createTimeStr;
    private Date updateTime;//更新该任务时间
    private String updateTimeStr;
    private Integer jobStatus;//服务状态：1代表启动，0代表停止
    private String description;//服务描述120字以内

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobGroupName='" + jobGroupName + '\'' +
                ", jobClassName='" + jobClassName + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", triggerGroupName='" + triggerGroupName + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", createTime=" + createTime +
                ", createTimeStr='" + createTimeStr + '\'' +
                ", updateTime=" + updateTime +
                ", updateTimeStr='" + updateTimeStr + '\'' +
                ", jobStatus=" + jobStatus +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        if(createTime != null){
            this.createTimeStr = ConverterUtils.dateToString(createTime, "yyyy-MM-dd HH:mm");
        }
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        if(updateTime != null){
            this.updateTimeStr = ConverterUtils.dateToString(updateTime, "yyyy-MM-dd HH:mm");
        }
        this.updateTime = updateTime;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
