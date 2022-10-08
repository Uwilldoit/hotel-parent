package com.wang.dao;

import com.wang.entity.Role;

import java.util.List;

public interface RoleMapper {
    /**
     * 根据用户ID查询角色列表
     * @param userId
     * @return
     */
    List<Role> findRoleListByUserId(Integer userId);
}
