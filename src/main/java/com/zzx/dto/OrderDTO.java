package com.zzx.dto;

import com.zzx.dataobject.OrderDetail;
import com.zzx.enums.OrderStatusEnum;
import com.zzx.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @Description
 * @Author zhangzx
 * @Date 2019/7/17 14:46
 * Version 1.0
 **/
@Data
public class OrderDTO {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    // 买家微信Opernid
    private String buyerOpenid;

    // 订单总金额
    private BigDecimal orderAmount;

    // 订单状态，默认0为新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    // 支付状态，默认0为新订单
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

    List<OrderDetail> orderDetailList;
}