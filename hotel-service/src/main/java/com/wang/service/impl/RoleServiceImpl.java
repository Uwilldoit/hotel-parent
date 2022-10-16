package com.wang.service.impl;

import com.wang.dao.RoleMapper;
import com.wang.entity.Role;
import com.wang.service.RoleService;
import com.wang.vo.RoleVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    /**
     * 查询角色列表
     * @param roleVo
     * @return
     */
    public List<Role> findRoleList(RoleVo roleVo) {
        return roleMapper.findRoleList(roleVo);
    }

    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    public int deleteById(Integer id) {
        return roleMapper.deleteById(id);
    }

    public List<Map<String, Object>> findRoleListByMap() {
        return roleMapper.findRoleListByMap();
    }

    public List<Integer> findRoleListWithUserId(Integer userId) {
        return roleMapper.findRoleListWithUserId(userId);
    }

    public boolean saveRolePermission(String permissionIds, Integer roleId) {
        try {
            //删除原有的角色菜单关系
            roleMapper.deleteRolePermissionByRoleId(roleId);
            //将权限菜单字符串拆分成数组
            String[] ids = permissionIds.split(",");
            int count = 0;
            //循环添加角色菜单关系
            for (int i = 0; i < ids.length; i++) {
                count =  roleMapper.saveRolePermission(Integer.valueOf(ids[i]),roleId);
            }
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return false;
    }
}

