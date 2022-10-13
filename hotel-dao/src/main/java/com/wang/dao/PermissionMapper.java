package com.wang.dao;

import com.wang.entity.Permission;
import com.wang.vo.PermissionVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {
    /**
     * 查询菜单列表
     * @param permissionVo
     * @return
     */
    List<Permission>findPermissionList(PermissionVo permissionVo);

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
    @Select("select count(1) from sys_permission where pid = #{id}")
    int getPermissionCountById(Integer id);


    /**
     * 删除菜单
     * @param id
     * @return
     */
    @Delete("delete from sys_permission where id = #{id}")
    int deleteById(Integer id);
}
