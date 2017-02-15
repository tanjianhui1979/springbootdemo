package com.springbootdemo.sdk.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanjianhui on 2017/2/13.
 */
public abstract class BaseModel implements Serializable{
    private Map<String, Object> properties = new HashMap<>();

    public void setProperties(Map<String, Object> properties){
        this.properties.putAll(properties);
    }

    public void setProperty(String key, Object value){
        this.properties.put(key, value);
    }

    public Object getProperty(String key){
        return this.properties.get(key);
    }

    public <T> T getProperty(String key, Class<T> clazz){
        Object obj = this.properties.get(key);
        if(null == obj || !clazz.isInstance(obj)) return null;
        return (T)obj;
    }
}
