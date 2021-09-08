package com.hxts.service;

import com.hxts.entity.PageResult;
import com.hxts.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {

    /**
     * 增加检查项
     * @param checkItem 检查项
     */
    void add(CheckItem checkItem);

    /**
     * 检查项分页查询
     * @param currentPage 当前页
     * @param pageSize  页码总数
     * @param queryString  查询条件
     * @return
     */
    PageResult pageQuery(Integer currentPage, Integer pageSize ,String queryString);

    /**
     * 检查项删除
     * @param id 检查项id
     */
    void delete(Integer id);

    void edit(CheckItem checkItem);

    CheckItem findById(Integer id);

    List<CheckItem> findAll();
}
