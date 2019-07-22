package com.zzx.service.impl;

import com.zzx.dto.OrderDTO;
import com.zzx.service.OrderService;
import com.zzx.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

//    @Test
//    public void create() throws Exception{
//        OrderDTO orderDTO = orderService.findOne("1563421483706252149");
//        payService.create(orderDTO);
//    }

//    @Test
//    public void refund() {
//        OrderDTO orderDTO = orderService.findOne("1499592887470659070");
//        payService.refund(orderDTO);
//    }
}