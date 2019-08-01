package com.zzx.controller;

import com.zzx.VO.ProductInfoVO;
import com.zzx.VO.ProductVO;
import com.zzx.VO.ResultVO;
import com.zzx.dataobject.ProductCategory;
import com.zzx.dataobject.ProductInfo;
import com.zzx.service.CategoryService;
import com.zzx.service.ProductService;
import com.zzx.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BuyerProductController
 * @Description 买家商品类
 * @Author zhangzx
 * @Date 2019/7/17 9:32
 * Version 1.0
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    // 查询商品列表
    @GetMapping("/list")
    public ResultVO list() {
        // 1.查询所有在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2.查询类目
        List<Integer> categoryTypeList = new ArrayList<>();
        // 传统方法
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }

        // 精简方法（java8，lamba）
//        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3.数据拼装
        // 把类目中需要用到的信息放到返回用的实体
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                // 如果商品类目的类型和在架商品的类目类型相等，则取出
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // 放到我们的返回实体ProductInfoVO中
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    // 放到我们的ProductInfoVOList
                    productInfoVOList.add((productInfoVO));
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        ResultVO resultVO = new ResultVO();
//        ProductVO productVO = new ProductVO();
//        ProductInfoVO productInfoVO = new ProductInfoVO();
//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
//        resultVO.setData(Arrays.asList(productVO));

        // 放入顺序：productInfo -> productInfoVO -> productInfoVOList -> productVO -> productVOList -> ResultVO.Data
//        resultVO.setData(productVOList) ;
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        return resultVO;
        return ResultVOUtil.success(productVOList);
    }
}
