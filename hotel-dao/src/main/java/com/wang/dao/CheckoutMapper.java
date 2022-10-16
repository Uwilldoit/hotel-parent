package com.wang.dao;

import com.wang.entity.Checkout;

public interface CheckoutMapper {
    /**
     * 添加退房记录
     * @param checkout
     * @return
     */
    int addCheckout(Checkout checkout);
}
