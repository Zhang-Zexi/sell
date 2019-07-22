package com.zzx.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.zzx.dto.OrderDTO;

/**
 * @ClassName PayService
 * @Description
 * @Author zhangzx
 * @Date 2019/7/19 19:17
 * Version 1.0
 **/
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
