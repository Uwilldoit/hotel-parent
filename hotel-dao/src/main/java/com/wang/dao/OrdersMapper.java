package com.wang.dao;

import com.wang.entity.Orders;
import com.wang.vo.OrdersVo;

import java.util.List;

public interface OrdersMapper {

    /**
     * 添加订单
     * @param orders
     * @return
     */
    int addOrders(Orders orders);
    /**
     * 查询订单列表
     * @param ordersVo
     * @return
     */
    List<Orders> findOrdersList(OrdersVo ordersVo);

    /**
     * 修改订单
     * @param orders
     * @return
     */
    int update(Orders orders);
}
