package com.springbootdemo.sdk.service;

import com.springbootdemo.sdk.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public abstract class BaseService<K,E,X,M extends BaseMapper<K,E,X>>{
  protected abstract M getMapper();

  public int countByExample(X example){
    return getMapper().countByExample(example);
  }

  public List<E> selectByExample(X example){
    return getMapper().selectByExample(example);
  }

  public E selectByPrimaryKey(K id){
    return getMapper().selectByPrimaryKey(id);
  }

  /*public <T> List selectByPage(PageModel<T> page){
    return getMapper().selectByPage(page);
  }*/

  @Transactional
  public int deleteByExample(X example){
    return getMapper().deleteByExample(example);
  }

  @Transactional
  public int deleteByPrimaryKey(K id){
    return getMapper().deleteByPrimaryKey(id);
  }

  @Transactional
  public int insert(E record){
    return getMapper().insert(record);
  }

  @Transactional
  public int insertSelective(E record){
    return getMapper().insertSelective(record);
  }

  @Transactional
  public int updateByExampleSelective(@Param("record") E record, @Param("example") X example){
    return getMapper().updateByExampleSelective(record,example);
  }

  @Transactional
  public int updateByExample(@Param("record") E record, @Param("example") X example){
    return getMapper().updateByExample(record,example);
  }

  @Transactional
  public int updateByPrimaryKeySelective(E record){
    return getMapper().updateByPrimaryKeySelective(record);
  }

  @Transactional
  public int updateByPrimaryKey(E record){
    return getMapper().updateByPrimaryKey(record);
  }
}