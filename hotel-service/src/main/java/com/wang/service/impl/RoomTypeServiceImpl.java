package com.wang.service.impl;

import com.wang.dao.RoomTypeMapper;
import com.wang.entity.RoomType;
import com.wang.service.RoomTypeService;
import com.wang.vo.RoomTypeVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService {
    @Resource
    private RoomTypeMapper roomTypeMapper;

    /**
     * 查询房型列表
     *
     * @param roomTypeVo
     * @return
     */
    public List<RoomType> findRoomTypeList(RoomTypeVo roomTypeVo) {
        return roomTypeMapper.findRoomTypeList(roomTypeVo);
    }

    public int insert(RoomType roomType) {
        //设置已预订数量
        roomType.setReservedNum(0);
        //设置可入住房间数量
        roomType.setAvailableNum(roomType.getRoomNum());
        //设置已入住房间数量
        roomType.setLivedNum(0);
        return roomTypeMapper.insert(roomType);
    }
}
