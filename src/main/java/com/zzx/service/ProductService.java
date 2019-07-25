package com.zzx.service;

import com.zzx.dataobject.ProductInfo;
import com.zzx.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description
 * @Author zhangzx
 * @Date 2019/7/16 19:58
 * Version 1.0
 **/
public interface ProductService {

    ProductInfo findOne(String productId);

    // 查询在架商品
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    // 上架
    ProductInfo onSale(String productId);

    // 下架
    ProductInfo offSale(String productId);

}
