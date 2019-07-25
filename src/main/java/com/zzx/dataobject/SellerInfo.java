package com.zzx.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName SellerInfo
 * @Description
 * @Author zhangzx
 * @Date 2019/7/23 14:45
 * Version 1.0
 **/
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
