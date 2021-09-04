package com.hxts.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxts.dao.CheckItemDao;
import com.hxts.entity.PageResult;
import com.hxts.pojo.CheckItem;
import com.hxts.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {


        PageInfo<CheckItem>  pageInfo = null;
        try{
            PageHelper.startPage(currentPage,pageSize);
            List<CheckItem> checkItems = checkItemDao.selectByCondition(queryString);
            pageInfo = new PageInfo<CheckItem>(checkItems);
        } finally {
             PageHelper.clearPage();
        }
         return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }
}
