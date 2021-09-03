package com.hxts.service;

import com.hxts.entity.PageResult;
import com.hxts.pojo.CheckItem;

public interface CheckItemService {

    void add(CheckItem checkItem);

    PageResult pageQuery(Integer currentPage, Integer pageSize ,String queryString);
}
