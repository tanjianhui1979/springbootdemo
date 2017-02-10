package com.springbootdemo.model;

import java.util.Date;

public class ScheduleTask {
    private Integer id;

    private String operation;

    private String jobName;

    private String cronExpression;

    private String argument;

    private Integer anticipateCostTime;

    private Integer maxAnticipateCostTime;

    private String status;

    private String remark;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public Integer getAnticipateCostTime() {
        return anticipateCostTime;
    }

    public void setAnticipateCostTime(Integer anticipateCostTime) {
        this.anticipateCostTime = anticipateCostTime;
    }

    public Integer getMaxAnticipateCostTime() {
        return maxAnticipateCostTime;
    }

    public void setMaxAnticipateCostTime(Integer maxAnticipateCostTime) {
        this.maxAnticipateCostTime = maxAnticipateCostTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}