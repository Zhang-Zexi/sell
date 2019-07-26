package com.zzx.service;

import com.zzx.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    // 根据类目Id查找类目信息
    ProductCategory findOne(Integer categoryId);

    // 查找所有类目信息
    List<ProductCategory> findAll();

    // 根据类目类型查找类目信息
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    // 保存类目信息
    ProductCategory save(ProductCategory productCategory);
}
