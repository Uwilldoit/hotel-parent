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



}
