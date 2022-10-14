package com.wang.service;

import com.wang.entity.SysUser;
import com.wang.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface SysUserService extends UserDetailsService {

    /**
     * 根据部门编号查询该部门下的员工信息
     * @param deptId
     * @return
     */
    int getUserCountByDeptId(Integer deptId);

    /**
     * 根据角色编号查询该角色下用户数量
     * @param roleId
     * @return
     */
    int getUserCountByRoleId(Integer roleId);

    /**
     * 查询用户列表
     * @param userVo
     * @return
     */
    List<SysUser> findUserList(UserVo userVo);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 更新用户
     * @param sysUser
     * @return
     */
    int updateUser(SysUser sysUser);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 重置密码
     * @param id
     * @return
     */
    int resetPwd(Integer id);
}
