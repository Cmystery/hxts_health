package com.hxts.service;

import com.hxts.pojo.User;

public interface UserService {
    User findByUsername(String username);
}
