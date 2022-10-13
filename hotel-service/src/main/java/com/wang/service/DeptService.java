package com.wang.service;

import com.wang.entity.Dept;
import com.wang.vo.DeptVo;

import java.util.List;

public interface DeptService {

    /**
     * 查询部门列表
     * @param deptVo
     * @return
     */
    List<Dept> findDeptList(DeptVo deptVo);

    /**
     * 添加部门
     * @param record
     * @return
     */
    int insert(Dept record);

    /**
     * 修改部门
     * @param dept
     * @return
     */
    int updateDept(Dept dept);

    /**
     * 删除部门
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 查询部门数据并缓存
     * @return
     */
    String findDeptList();
}
