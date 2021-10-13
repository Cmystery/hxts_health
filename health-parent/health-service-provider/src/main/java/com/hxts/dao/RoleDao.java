package com.hxts.dao;

import com.hxts.pojo.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> findByUserId(Integer userId);
}
