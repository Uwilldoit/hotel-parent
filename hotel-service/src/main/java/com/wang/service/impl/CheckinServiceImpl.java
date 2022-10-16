package com.wang.service.impl;

import com.wang.dao.CheckinMapper;
import com.wang.dao.OrdersMapper;
import com.wang.dao.RoomTypeMapper;
import com.wang.entity.Checkin;
import com.wang.entity.Orders;
import com.wang.entity.RoomType;
import com.wang.service.CheckinService;
import com.wang.vo.CheckinVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class CheckinServiceImpl implements CheckinService {
    @Resource
    private CheckinMapper checkinMapper;

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private RoomTypeMapper roomTypeMapper;

    public List<Checkin> findCheckinList(CheckinVo checkinVo) {
        return checkinMapper.findCheckinList(checkinVo);
    }

    @Transactional(rollbackFor = RuntimeException.class)//运行异常时就回滚
    public int insert(Checkin checkin) {
        //设置状态
        checkin.setStatus(1);//入住中
        checkin.setCreateDate(new Date());//创建时间
        //调用添加入住信息的方法
        int count = checkinMapper.insert(checkin);
        //如果添加成功
        if (count>0){
            //修改预定订单信息（从已确认的状态2改成入住中状态3）
            Orders orders = new Orders();
            orders.setId(checkin.getOrdersId());
            orders.setStatus(3);//入住中
            //调用修改订单信息的方法
            ordersMapper.update(orders);

            //修改房型信息（已入住数量+1）
            RoomType roomType =roomTypeMapper.findById(checkin.getRoomTypeId());
            roomType.setLivedNum(roomType.getLivedNum()+1);
            //调用修改房型的方法
            roomTypeMapper.updateRoomType(roomType);
        }
        return 0;
    }
}
