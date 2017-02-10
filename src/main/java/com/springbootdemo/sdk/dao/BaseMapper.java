package com.springbootdemo.sdk.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<K,E,X> {
  int countByExample(X example);

  int deleteByExample(X example);

  int deleteByPrimaryKey(K id);

  int insert(E record);

  int insertSelective(E record);

  List<E> selectByExample(X example);

  E selectByPrimaryKey(K id);

  int updateByExampleSelective(@Param("record") E record, @Param("example") X example);

  int updateByExample(@Param("record") E record, @Param("example") X example);

  int updateByPrimaryKeySelective(E record);

  int updateByPrimaryKey(E record);

//  <T> List<E> selectByPage(PageModel<T> page);
}
