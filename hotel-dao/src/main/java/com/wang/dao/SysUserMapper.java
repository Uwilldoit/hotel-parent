package com.wang.dao;

import com.wang.entity.SysUser;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper {
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    SysUser fidUserByUserName(String userName);

    /**
     * 根据部门编号查询该部门下的员工信息
     * @param deptId
     * @return
     */
    @Select("select count(1) from sys_user where deptId = #{deptId}")
    int getUserCountByDeptId(Integer deptId);
}
