package com.zzx.utils;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @Description
 * @Author zhangzx
 * @Date 2019/7/17 15:13
 * Version 1.0
 **/
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间 + 随机数
     * @return
     */
    public static  synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
