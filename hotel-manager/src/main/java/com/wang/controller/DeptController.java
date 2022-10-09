package com.wang.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.entity.Dept;
import com.wang.service.DeptService;
import com.wang.utils.DataGridViewResult;
import com.wang.vo.DeptVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/admin/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 查询部门列表
     * @param deptVo
     * @return
     */
    @RequestMapping("/list")
    public DataGridViewResult list(DeptVo deptVo){
        //设置分页信息
        PageHelper.startPage(deptVo.getPage(),deptVo.getLimit());
        //调用查询部门列表的方法
        List<Dept> deptList = deptService.findDeptList(deptVo);
        //创建分页对象
        PageInfo<Dept> pageInfo = new PageInfo<Dept>(deptList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

}
