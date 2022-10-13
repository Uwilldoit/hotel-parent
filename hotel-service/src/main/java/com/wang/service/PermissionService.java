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

    /**
     * 添加菜单
     * @param record
     * @return
     */
    int insert(Permission record);

    /**
     * 修改菜单
     * @param record
     * @return
     */
    int update(Permission record);

    /**
     * 检查菜单下是否有子菜单
     * @param id
     * @return
     */
    int getPermissionCountById(Integer id);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 根据角色ID查询该角色拥有的权限菜单ID集合
     * @param id
     * @return
     */
    List<Integer>findPermissionByRoleId(Integer id);

    /**
     * 根据菜单编号菜单详细信息
     * @param currentRolePermissions
     * @return
     */
    List<Permission> findPermissionById(List<Integer> currentRolePermissions);
}
