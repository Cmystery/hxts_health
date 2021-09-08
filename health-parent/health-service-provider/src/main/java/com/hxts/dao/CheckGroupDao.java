package com.hxts.dao;

import com.hxts.pojo.CheckGroup;

import java.util.Map;

public interface CheckGroupDao {
    void add(CheckGroup checkGroup);

    void setCheckGroupAndCheckItem(Map map);
}
