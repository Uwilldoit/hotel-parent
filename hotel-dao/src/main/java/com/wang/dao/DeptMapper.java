package com.wang.dao;

import com.wang.entity.Dept;
import com.wang.vo.DeptVo;
import com.wang.entity.Dept;

import java.util.List;

public interface DeptMapper {

    /**
     * 查询部门列表
     * @param deptVo
     * @return
     */
    List<Dept> findDeptList(DeptVo deptVo);


}
