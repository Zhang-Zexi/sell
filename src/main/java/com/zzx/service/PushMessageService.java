package com.zzx.service;

import com.zzx.dto.OrderDTO;

/**
 * @ClassName PushMessageService
 * @Description 推送消息
 * @Author zhangzx
 * @Date 2019/7/24 9:50
 * Version 1.0
 **/
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
