package com.springbootdemo.sdk.schedule;

/**
 * Created by tanjianhui on 2017/2/9.
 */
public enum  ScheduleStatus {
    NO("0"), // 未生效
    YES("1"); // 已生效

    private String key;

    ScheduleStatus(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
