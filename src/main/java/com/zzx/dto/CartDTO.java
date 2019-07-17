package com.zzx.dto;

import lombok.Data;

/**
 * @ClassName CartDTO
 * @Description 购物车
 * @Author zhangzx
 * @Date 2019/7/17 15:25
 * Version 1.0
 **/
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
