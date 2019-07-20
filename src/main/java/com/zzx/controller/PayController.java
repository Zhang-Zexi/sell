package com.zzx.controller;

import com.lly835.bestpay.model.PayResponse;
import java.util.Map;
import com.zzx.dto.OrderDTO;
import com.zzx.enums.ResultEnum;
import com.zzx.exception.SellException;
import com.zzx.service.OrderService;
import com.zzx.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName PayController
 * @Description
 * @Author zhangzx
 * @Date 2019/7/19 19:11
 * Version 1.0
 **/
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        // 1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        // 2.发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse );
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);

    }
}
