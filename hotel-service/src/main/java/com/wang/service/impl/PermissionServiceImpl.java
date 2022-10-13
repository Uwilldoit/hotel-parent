package com.wang.service.impl;

import com.wang.dao.PermissionMapper;
import com.wang.entity.Permission;
import com.wang.service.PermissionService;
import com.wang.vo.PermissionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 查询菜单列表
     *
     * @param permissionVo
     * @return
     */
    public List<Permission> findPermissionList(PermissionVo permissionVo) {
        return permissionMapper.findPermissionList(permissionVo);
    }

    public int insert(Permission permission) {
        //判断是否选中一级菜单
        if(permission.getPid()==null){
            permission.setPid(0);//0表示一级菜单
        }
        //打开方式
        permission.setTarget("_self");
        return permissionMapper.insert(permission);
    }

}
