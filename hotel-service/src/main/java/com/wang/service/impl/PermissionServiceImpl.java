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

    public List<Permission> findPermissionList(PermissionVo permissionVo) {
        return permissionMapper.findPermissionList(permissionVo);
    }
}
