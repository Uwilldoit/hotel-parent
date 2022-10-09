package com.wang.dao;

import com.wang.entity.Permission;
import com.wang.vo.PermissionVo;

import java.util.List;

public interface PermissionMapper {
    /**
     * 查询菜单列表
     * @param permissionVo
     * @return
     */
    List<Permission>findPermissionList(PermissionVo permissionVo);
}
