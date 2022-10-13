package com.wang.dao;

import com.wang.entity.Dept;
import com.wang.entity.Role;
import com.wang.vo.RoleVo;

import java.util.List;

public interface RoleMapper {
    /**
     * 根据用户ID查询角色列表
     * @param userId
     * @return
     */
    List<Role> findRoleListByUserId(Integer userId);

    /**
     * 查询角色列表
     * @param roleVo
     * @return
     */
    List<Role>findRoleList(RoleVo roleVo);

    /**
     * 添加角色
     * @param record
     * @return
     */
    int insert(Role record);

    /**
     * 修改角色
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    int deleteById(Integer id);


}
