package com.zzx.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zzx.enums.CodeEnum;
import com.zzx.enums.ProductStatusEnum;
import com.zzx.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ProductInfo
 * @Description
 * @Author zhangzx
 * @Date 2019/7/16 19:05
 * Version 1.0
 **/
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    // 库存
    private Integer productStock;

    private String productDescription;

    // 小图
    private String productIcon;

    // 状态 0正常 1下架
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    // 类目编号   PS：商品和类目的关联就用类目编号
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
