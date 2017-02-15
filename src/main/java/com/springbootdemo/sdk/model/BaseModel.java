package com.springbootdemo.sdk.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanjianhui on 2017/2/13.
 */
public abstract class BaseModel implements Serializable{
    private Map<String, Serializable> properties = new HashMap<>();

    public void setProperties(Map<String, Serializable> properties){
        this.properties.putAll(properties);
    }

    public void setProperty(String key, Serializable value){
        this.properties.put(key, value);
    }

    public Object getProperty(String key){
        return this.properties.get(key);
    }

    public <T extends Serializable> T getProperty(String key, Class<T> clazz){
        Object obj = this.properties.get(key);
        if(null == obj || !clazz.isInstance(obj)) return null;
        return (T)obj;
    }
}
