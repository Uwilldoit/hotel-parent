package com.wang.entity;

import lombok.Data;

@Data
public class RoomType {
    private Integer id;//房型编号
    private String typeName;//房型名称
    private String photo;//房型图片
    private Double price;//参考价格
    private Integer liveNum;//参考价格
    private Integer bedNum;//床位数
    private Integer roomNum;//房间数量
    private Integer reservedNum;//已预定数量
    private Integer availableNum;//可住房间数
    private Integer livedNum;//已入住数量
    private Integer status;//房型状态（1-可预订 2-房型已满）
    private String remark;//备注
}
