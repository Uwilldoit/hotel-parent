package com.wang.service.impl;


import com.wang.dao.DeptMapper;
import com.wang.entity.Dept;
import com.wang.service.DeptService;
import com.wang.vo.DeptVo;
import javafx.scene.chart.PieChart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.Date;
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

    /**
     * 添加部门
     * @param record
     * @return
     */
    public int insert(Dept record) {
        record.setCreateDate(new Date());
        return deptMapper.insert(record);
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    public int deleteById(Integer id) {
        return deptMapper.deleteById(id);
    }
}
