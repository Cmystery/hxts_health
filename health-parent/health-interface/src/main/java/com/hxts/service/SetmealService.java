package com.hxts.service;

import com.hxts.entity.PageResult;
import com.hxts.pojo.Setmeal;

import java.util.List;

/**
 * 体检套餐服务接口
 */
public interface SetmealService {

    void add(Setmeal setmeal, Integer[] checkgroupIds);

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    List<Setmeal> findAll();

    Setmeal findById(int id);
}
