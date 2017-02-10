package com.springbootdemo.dao;

import com.springbootdemo.model.ScheduleTask;
import com.springbootdemo.model.ScheduleTaskExample;
import com.springbootdemo.sdk.dao.BaseMapper;

import java.util.List;

public interface ScheduleTaskMapper extends BaseMapper<Integer,ScheduleTask,ScheduleTaskExample>{
    int updateStatusBatch(List<ScheduleTask> recordList);
}