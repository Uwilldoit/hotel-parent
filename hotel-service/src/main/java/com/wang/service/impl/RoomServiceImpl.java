package com.wang.service.impl;

import com.wang.dao.RoomMapper;
import com.wang.entity.Room;
import com.wang.service.RoomService;
import com.wang.vo.RoomVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;

    /**
     * 查询房间列表
     * @param roomVo
     * @return
     */
    public List<Room> findRoomList(RoomVo roomVo) {
        return roomMapper.findRoomList(roomVo);
    }

    public int addRoom(Room room) {
        return roomMapper.addRoom(room);
    }

    public int updateRoom(Room room) {
        return roomMapper.updateRoom(room);
    }

    public int deleteById(Integer id) {
        return roomMapper.deleteById(id);
    }
}
