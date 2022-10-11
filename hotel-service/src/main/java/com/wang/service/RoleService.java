package com.wang.service;

import com.wang.entity.Role;
import com.wang.vo.RoleVo;

import java.util.List;

public interface RoleService {
    /**
     * 查询角色列表
     * @param roleVo
     * @return
     */
    List<Role> findRoleList(RoleVo roleVo);

    /**
     * 添加角色
     * @param record
     * @return
     */
    int insert(Role record);


    /**
     * 删除角色
     * @param id
     * @return
     */
    int deleteById(Integer id);
}
