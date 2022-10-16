package com.wang.dao;

import com.wang.entity.Checkin;
import com.wang.vo.CheckinVo;

import java.util.List;

public interface CheckinMapper {
    /**
     *
     * @param checkinVo
     * @return
     */
    List<Checkin> findCheckinList(CheckinVo checkinVo);

    /**
     * 添加入住信息
     * @param checkin
     * @return
     */
    int insert(Checkin checkin);
}
