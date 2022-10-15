package com.wang.service.impl;

import com.alibaba.fastjson.JSON;
import com.wang.dao.RoomTypeMapper;
import com.wang.entity.RoomType;
import com.wang.service.RoomTypeService;
import com.wang.utils.JedisPoolUtils;
import com.wang.utils.RedisKey;
import com.wang.vo.RoomTypeVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

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

    public int getRoomCountByRoomTypeId(Integer roomTypeId) {
        return roomTypeMapper.getRoomCountByRoomTypeId(roomTypeId);
    }

    public int deleteById(Integer id) {
        return roomTypeMapper.deleteById(id);
    }

    public String getRoomTypeListByRedis() {
        Jedis jedis = JedisPoolUtils.getJedis();
        //读取缓存数据
        String room_type_list = jedis.get(RedisKey.ROOM_TYPE_LIST);
        //判断缓存是否存在数据
        if(StringUtils.isEmpty(room_type_list)){
            //从数据库中读取数据
            List<RoomType> roomTypeList = roomTypeMapper.findRoomTypeList(null);
            //转换成JSON并保存到缓存中
            room_type_list=jedis.set(RedisKey.ROOM_TYPE_LIST, JSON.toJSONString(roomTypeList));
        }
        return room_type_list;
    }
}
