package com.zzx.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName OrderDetail
 * @Description
 * @Author zhangzx
 * @Date 2019/7/17 11:38
 * Version 1.0
 **/
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    // 商品数量
    private Integer productQuantity;

    // 商品小图
    private String productIcon;
}
