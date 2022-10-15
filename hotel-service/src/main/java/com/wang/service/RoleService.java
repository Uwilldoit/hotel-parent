package com.wang.service;

import com.wang.entity.Role;
import com.wang.vo.RoleVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询所有角色
     * @return
     */

    List<Map<String,Object>> findRoleListByMap();

    /**
     * 根据用户ID查询该用户拥有的角色列表(只查询角色ID)
     * @param userId
     * @return
     */

    List<Integer> findRoleListWithUserId(Integer userId);

    /**
     * 保存角色菜单关系
     * @param permissionIds
     * @param roleId
     * @return
     */
    boolean saveRolePermission(String permissionIds, Integer roleId);
}
