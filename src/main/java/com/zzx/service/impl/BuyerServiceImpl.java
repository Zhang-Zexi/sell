package com.zzx.service.impl;

import com.zzx.dto.OrderDTO;
import com.zzx.enums.ResultEnum;
import com.zzx.exception.SellException;
import com.zzx.service.BuyerService;
import com.zzx.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BuyerServiceImpl
 * @Description
 * @Author zhangzx
 * @Date 2019/7/18 15:01
 * Version 1.0
 **/
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到该订单, orderId={}", orderId);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    // 简化，复用代码
    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        // 判断是否自己订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单openip不一致, openid={}, orderDTO={}", openid, orderId);
            throw new SellException(ResultEnum.ORDER_OWNER_ERRO);
        }
        return orderDTO;
    }
}
