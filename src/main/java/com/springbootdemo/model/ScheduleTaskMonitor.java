package com.springbootdemo.model;

import java.util.Date;

public class ScheduleTaskMonitor {
    private Integer id;

    private Integer scheduleTaskId;

    private Date jobStartTime;

    private Date jobEndTime;

    private Date jobAnticipateEndTime;

    private Date jobMaxAnticipateEndTime;

    private String status;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScheduleTaskId() {
        return scheduleTaskId;
    }

    public void setScheduleTaskId(Integer scheduleTaskId) {
        this.scheduleTaskId = scheduleTaskId;
    }

    public Date getJobStartTime() {
        return jobStartTime;
    }

    public void setJobStartTime(Date jobStartTime) {
        this.jobStartTime = jobStartTime;
    }

    public Date getJobEndTime() {
        return jobEndTime;
    }

    public void setJobEndTime(Date jobEndTime) {
        this.jobEndTime = jobEndTime;
    }

    public Date getJobAnticipateEndTime() {
        return jobAnticipateEndTime;
    }

    public void setJobAnticipateEndTime(Date jobAnticipateEndTime) {
        this.jobAnticipateEndTime = jobAnticipateEndTime;
    }

    public Date getJobMaxAnticipateEndTime() {
        return jobMaxAnticipateEndTime;
    }

    public void setJobMaxAnticipateEndTime(Date jobMaxAnticipateEndTime) {
        this.jobMaxAnticipateEndTime = jobMaxAnticipateEndTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}