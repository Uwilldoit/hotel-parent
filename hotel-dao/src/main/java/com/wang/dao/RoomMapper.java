package com.wang.dao;

import com.wang.entity.Room;
import com.wang.vo.RoomVo;

import java.util.List;

public interface RoomMapper {
    /**
     * 查询房间列表
     * @param roomVo
     * @return
     */
    List<Room> findRoomList(RoomVo roomVo);

    /**
     * 添加房间
     * @param room
     * @return
     */
    int addRoom(Room room);
}
