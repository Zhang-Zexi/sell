package com.zzx.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zzx.enums.ProductStatusEnum;
import com.zzx.utils.EnumUtil;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ProductForm
 * @Description
 * @Author zhangzx
 * @Date 2019/7/23 9:48
 * Version 1.0
 **/
@Data
public class ProductForm {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    // 库存
    private Integer productStock;

    private String productDescription;

    // 小图
    private String productIcon;

    // 类目编号   PS：商品和类目的关联就用类目编号
    private Integer categoryType;
}
