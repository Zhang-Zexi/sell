package com.zzx.service.impl;

import com.zzx.dataobject.SellerInfo;
import com.zzx.repository.SellerInfoRepository;
import com.zzx.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SellerServiceImpl
 * @Description
 * @Author zhangzx
 * @Date 2019/7/23 14:59
 * Version 1.0
 **/
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
