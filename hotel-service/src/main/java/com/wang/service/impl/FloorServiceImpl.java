package com.wang.service.impl;

import com.wang.dao.FloorMapper;
import com.wang.entity.Floor;
import com.wang.service.FloorService;
import com.wang.vo.FloorVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return floorMapper.updateFloor(floor);
    }

    public int insert(Floor floor) {
        return floorMapper.insert(floor);
    }

}
