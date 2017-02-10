package com.springbootdemo.sdk.schedule;

/**
 * Created by tanjianhui on 2017/2/9.
 */
public enum OperationType {
    /** 新增 */
    ADD("1"),
    /** 暂停 */
    PAUSE("2"),
    /** 恢复 */
    RESUME("3"),
    /** 其他 */
    Other("9");

    private String key;

    OperationType(String key){
        this.key = key;
    }

    public static OperationType getOperationType(String key) {
        for(OperationType operationType : OperationType.values()){
            if(operationType.key.equals(key)){
                return operationType;
            }
        }
        return Other;
    }
}
