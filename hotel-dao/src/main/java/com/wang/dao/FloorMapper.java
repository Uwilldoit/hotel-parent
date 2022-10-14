package com.wang.dao;

import com.wang.entity.Floor;
import com.wang.vo.FloorVo;

import java.util.List;

public interface FloorMapper {
    /**
     * 查询楼层列表
     * @param floorVo
     * @return
     */
    List<Floor> findFloorList(FloorVo floorVo);

    /**
     * 添加楼层
     * @param floor
     * @return
     */
    int insert(Floor floor);

    /**
     * 修改楼层
     * @param floor
     * @return
     */
    int updateFloor(Floor floor);

}
