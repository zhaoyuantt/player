package com.landasoft.players.service;

import com.landasoft.players.pojo.TOrder;

/**
 * 订单Service接口
 * @author zhaoyaun
 * @date 2020,Jan 18 5:22 pm
 */
public interface OrderService {

    /**
     * 保存订单
     * @param order
     */
    public void saveOrder(TOrder order);

    /**
     * 更新订单状态
     * @param orderId
     * @param payment
     * @param state
     */
    void updateOrderState(String orderId,String payment,int state);
}
