package com.wang.service.impl;


import com.alibaba.fastjson.JSON;
import com.wang.dao.DeptMapper;
import com.wang.entity.Dept;
import com.wang.service.DeptService;
import com.wang.utils.JedisPoolUtils;
import com.wang.utils.RedisKey;
import com.wang.vo.DeptVo;
import javafx.scene.chart.PieChart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;


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

    public String findDeptList() {
        //获取jedis对象
        Jedis jedis = JedisPoolUtils.getJedis();
        //读取缓存中数据，如果存在数据则直接返回
        String dept_list = jedis.get(RedisKey.DEPT_LIST);
        if(StringUtils.isEmpty(dept_list)){
            //1.从数据库中查询
            List<Dept> deptList = deptMapper.findDeptList(null);
            //2.将数据保存到缓存中
            dept_list=jedis.set(RedisKey.DEPT_LIST, JSON.toJSONString(deptList));
        }


        return dept_list;
    }
}
