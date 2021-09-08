package com.hxts.dao;

import com.hxts.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckItemDao {

    void add(CheckItem checkItem);

    List<CheckItem> selectByCondition(@Param("queryString") String queryString);

    void deleteById(@Param("id") Integer id);

    long findCountByCheckItemId(@Param("id") Integer id);

    void update(CheckItem checkItem);

    CheckItem findById(@Param("id") Integer id);

}
