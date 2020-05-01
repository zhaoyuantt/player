package com.landasoft.players.service.impl;

import com.landasoft.players.mapper.TOrderMapper;
import com.landasoft.players.pojo.TOrder;
import com.landasoft.players.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 订单Service接口实现
 * @author zhaoyaun
 * @date 2020,Jan 18 5:25 pm
 */
@Service
public class OrderServiceImpl implements OrderService{

    private static final Logger log = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    private TOrderMapper orderMapper;

    @Override
    public void saveOrder(TOrder order) {
        int iResult = orderMapper.insert(order);
        if(0 < iResult){
            log.info(order.getOrderId()+"订单保存成功");
        }
    }

    @Override
    public void updateOrderState(String orderId,String payment,int state) {
        if(StringUtils.isEmpty(orderId)){
            throw new RuntimeException("更新订单状态时，订单Id为空");
        }

        TOrder order = orderMapper.selectByPrimaryKey(orderId);

        if(null != order){
            order.setPayment(payment);
            order.setStates((byte) state);
            order.setUpdated(new Date());
            order.setEndTime(new Date());

            int uResult = orderMapper.updateByPrimaryKey(order);

            if(0 < uResult){
                log.info(order.getOrderId()+"订单状态更新成功，状态为："+order.getStates());
            }
        }
    }
}
