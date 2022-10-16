package com.wang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.entity.Checkin;
import com.wang.service.CheckinService;
import com.wang.utils.DataGridViewResult;
import com.wang.vo.CheckinVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/checkin")
public class CheckinController {
    @Resource
    private CheckinService checkinService;

    /**
     *  查询入住列表
     * @param checkinVo
     * @return
     */
    @RequestMapping("/list")
    public DataGridViewResult list(CheckinVo checkinVo){
        //设置分页信息
        PageHelper.startPage(checkinVo.getPage(),checkinVo.getLimit());
        //调用方法
        List<Checkin> checkinList = checkinService.findCheckinList(checkinVo);
        //创建分页对象
        PageInfo<Checkin> pageInfo = new PageInfo<Checkin>(checkinList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }
}
