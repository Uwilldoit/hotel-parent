package com.wang.service;

import com.wang.entity.Permission;
import com.wang.vo.PermissionVo;

import java.util.List;

public interface PermissionService {
    /**
     * 查询菜单列表
     * @param permissionVo
     * @return
     */
    List<Permission> findPermissionList(PermissionVo permissionVo);
}
