package com.zzx.controller;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.zzx.config.ProjectUrlConfig;
import com.zzx.constant.CookieConstant;
import com.zzx.constant.RedisConstant;
import com.zzx.dataobject.SellerInfo;
import com.zzx.enums.ResultEnum;
import com.zzx.service.SellerService;
import com.zzx.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName SellerUserController
 * @Description 卖家用户
 * @Author zhangzx
 * @Date 2019/7/23 17:20
 * Version 1.0
 **/
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String, Object> map) {

        //1. openid去和数据库的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        //2. 设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);

        //3. 设置token至cookie
        CookieUtil.set(response, "token", token, expire);

        return new ModelAndView("redirect:" + projectUrlConfig.getSell() +  "/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String, Object> map) {
        // 1.从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            // 2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
            // 3.清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN ,null, 0);
        }

        map.put("msg", ResultEnum.LOGIN_SUCCESS.getMessage());
        map.put("url", "sell/seller/order/list");
        return new ModelAndView("common/success", map);

    }
}
