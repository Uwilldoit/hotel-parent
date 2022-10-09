package com.wang.service.impl;


import com.wang.dao.DeptMapper;
import com.wang.entity.Dept;
import com.wang.service.DeptService;
import com.wang.vo.DeptVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    /**
     * 查询部门列表
     *
     * @param deptVo
     * @return
     */
    public List<Dept> findDeptList(DeptVo deptVo) {
        return deptMapper.findDeptList(deptVo);
    }


}
