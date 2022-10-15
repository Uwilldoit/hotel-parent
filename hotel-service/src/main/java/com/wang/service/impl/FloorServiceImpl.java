package com.wang.service.impl;

import com.alibaba.fastjson.JSON;
import com.wang.dao.FloorMapper;
import com.wang.entity.Floor;
import com.wang.service.FloorService;
import com.wang.utils.JedisPoolUtils;
import com.wang.utils.RedisKey;
import com.wang.vo.FloorVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class FloorServiceImpl implements FloorService {
    @Resource
    private FloorMapper floorMapper;

    /**
     * 查询楼层列表
     * @param floorVo
     * @return
     */
    public List<Floor> findFloorList(FloorVo floorVo) {
        return floorMapper.findFloorList(floorVo);
    }

    public int updateFloor(Floor floor) {
        //删除Redis缓存中的数据
        JedisPoolUtils.getJedis().del(RedisKey.FLOOR_LIST);
        return floorMapper.updateFloor(floor);
    }

    public String getFloorListByRedis() {
        Jedis jedis = JedisPoolUtils.getJedis();
        //从Redis缓存中读取数据
        String floor_list = jedis.get(RedisKey.FLOOR_LIST);
        //判断缓存是否存在数据
        if (StringUtils.isEmpty(floor_list)){
            //查询数据库
            List<Floor> floorList = floorMapper.findFloorList(null);
            //将数据转换成JSON并保存到缓存中
            floor_list= jedis.set(RedisKey.FLOOR_LIST, JSON.toJSONString(floorList));
        }
        return floor_list;
    }

    public int insert(Floor floor) {
        //删除Redis缓存中的数据
        JedisPoolUtils.getJedis().del(RedisKey.FLOOR_LIST);
        return floorMapper.insert(floor);
    }

}
