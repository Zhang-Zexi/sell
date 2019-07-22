package com.zzx.utils;

import com.zzx.enums.CodeEnum;

/**
 * @ClassName EnumUtil
 * @Description
 * @Author zhangzx
 * @Date 2019/7/22 15:18
 * Version 1.0
 **/
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
