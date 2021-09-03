package com.hxts.dao;

import com.hxts.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {

    void add(CheckItem checkItem);

    List<CheckItem> selectByCondition(String queryString);
}
