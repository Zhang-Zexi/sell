package com.zzx.dataobject.dao;

import com.zzx.dataobject.ProductCategory;
import com.zzx.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @ClassName ProductCategoryDao
 * @Description
 * @Author zhangzx
 * @Date 2019/7/24 15:15
 * Version 1.0
 **/
public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }

}
