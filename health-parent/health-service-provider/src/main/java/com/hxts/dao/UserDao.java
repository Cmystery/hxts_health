package com.hxts.dao;

import com.hxts.pojo.User;

public interface UserDao {
    User findByUsername(String username);
}
