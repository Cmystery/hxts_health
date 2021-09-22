package com.hxts.dao;

import com.github.pagehelper.Page;
import com.hxts.pojo.Setmeal;

import java.util.Map;

public interface SetmealDao {

    void add(Setmeal setmeal);

    void setSetmealAndCheckGroup(Map<String, Integer> map);

    Page<Setmeal> selectByCondition(String queryString);
}
