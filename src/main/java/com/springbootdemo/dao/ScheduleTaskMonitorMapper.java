package com.springbootdemo.dao;

import com.springbootdemo.model.ScheduleTaskMonitor;
import com.springbootdemo.model.ScheduleTaskMonitorExample;
import java.util.List;

import com.springbootdemo.sdk.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface ScheduleTaskMonitorMapper extends BaseMapper<Integer, ScheduleTaskMonitor, ScheduleTaskMonitorExample> {

    int insertSelectiveUseGeneratedKeys(ScheduleTaskMonitor record);

    List<ScheduleTaskMonitor> selectByExampleWithBLOBs(ScheduleTaskMonitorExample example);

    int updateByExampleWithBLOBs(@Param("record") ScheduleTaskMonitor record, @Param("example") ScheduleTaskMonitorExample example);

    int updateByPrimaryKeyWithBLOBs(ScheduleTaskMonitor record);
}