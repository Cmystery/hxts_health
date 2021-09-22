package com.hxts.dao;

import com.hxts.pojo.OrderSetting;

import java.util.Date;

public interface OrderSettingDao {

    void add(OrderSetting orderSetting);

    void editNumberByOrderDate(OrderSetting orderSetting);

    long findCountByOrderDate(Date orderDate);
}