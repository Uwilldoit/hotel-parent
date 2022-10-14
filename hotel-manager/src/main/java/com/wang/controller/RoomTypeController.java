package com.wang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.entity.RoomType;
import com.wang.service.RoomTypeService;
import com.wang.utils.DataGridViewResult;
import com.wang.vo.RoomTypeVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/roomType")
public class RoomTypeController {
    @Resource
    private RoomTypeService roomTypeService;

    /**
     * 查询房型列表
     * @param
     * @return
     */
    @RequestMapping("/list")
    public DataGridViewResult list(RoomTypeVo roomTypeVo){
        //设置分页信息
        PageHelper.startPage(roomTypeVo.getPage(),roomTypeVo.getLimit());
        //调用查询部门列表的方法
        List<RoomType> roleList = roomTypeService.findRoomTypeList(roomTypeVo);
        //创建分页对象
        PageInfo<RoomType> pageInfo = new PageInfo<RoomType>(roleList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }
}
