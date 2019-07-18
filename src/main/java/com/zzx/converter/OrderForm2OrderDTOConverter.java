package com.zzx.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zzx.dataobject.OrderDetail;
import com.zzx.dto.OrderDTO;
import com.zzx.enums.ResultEnum;
import com.zzx.exception.SellException;
import com.zzx.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.hibernate.loader.custom.ResultRowProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderForm2OrderDTOConverter
 * @Description
 * @Author zhangzx
 * @Date 2019/7/18 10:27
 * Version 1.0
 **/
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
