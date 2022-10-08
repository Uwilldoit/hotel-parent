package com.wang.dao;

import com.wang.entity.SysUser;

public interface SysUserMapper {
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    SysUser fidUserByUserName(String userName);
}
