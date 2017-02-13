package com.springbootdemo.service;

import com.springbootdemo.dao.ScheduleTaskMonitorMapper;
import com.springbootdemo.model.ScheduleTaskMonitor;
import com.springbootdemo.model.ScheduleTaskMonitorExample;
import com.springbootdemo.sdk.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tanjianhui on 2017/2/13.
 */
@Service("scheduleTaskMonitorService")
public class ScheduleTaskMonitorService extends BaseService<Integer, ScheduleTaskMonitor, ScheduleTaskMonitorExample,
        ScheduleTaskMonitorMapper> {
    @Autowired
    private ScheduleTaskMonitorMapper scheduleTaskMonitorMapper;

    @Override
    protected ScheduleTaskMonitorMapper getMapper(){
        return this.scheduleTaskMonitorMapper;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int addRequestNew(ScheduleTaskMonitor record){
        return this.scheduleTaskMonitorMapper.insertSelective(record);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateRequestNew(ScheduleTaskMonitor record){
        return this.scheduleTaskMonitorMapper.updateByPrimaryKeySelective(record);
    }
}
