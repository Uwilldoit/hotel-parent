package com.wang.dao;

import com.wang.entity.RoomType;
import com.wang.vo.RoomTypeVo;

import java.util.List;

public interface RoomTypeMapper {

    /**
     * 查询房型列表
     * @param roomTypeVo
     * @return
     */
    List<RoomType> findRoomTypeList(RoomTypeVo roomTypeVo);
}
