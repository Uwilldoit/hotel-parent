package com.wang.service.impl;

import com.wang.dao.SysUserMapper;
import com.wang.entity.Role;
import com.wang.entity.SysUser;
import com.wang.service.SysUserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper userMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //创建角色列表集合
        List<SimpleGrantedAuthority>authorities=new ArrayList<SimpleGrantedAuthority>();
        //根据用户姓名查询用户信息的方法
        SysUser sysUser=userMapper.fidUserByUserName(username);
        //循环遍历用户角色列表 iter
        for (Role role : sysUser.getRoleList()){
            //将角色编码添加到角色列表集合中
            authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
        }
        //创建User对象 spring security
        User user = new User(sysUser.getUserName(),
                sysUser.getPassword(),
                sysUser.getStatus()==1,
                true,
                true,
                true,
                authorities);
        return user;
    }
}
