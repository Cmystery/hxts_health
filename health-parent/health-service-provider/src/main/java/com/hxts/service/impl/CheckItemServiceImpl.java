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

    @Override
    public void delete(Integer id) throws RuntimeException{
        //查询当前检查项是否和检查组关联
        long count = checkItemDao.findCountByCheckItemId(id);
        if(count > 0){
            //当前检查项被引用，不能删除
            throw new RuntimeException("当前检查项被引用，不能删除");
        }
        checkItemDao.deleteById(id);
    }

    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.update(checkItem);
    }

    @Override
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.selectByCondition(null);
    }
}
