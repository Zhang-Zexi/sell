package com.zzx.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @ClassName JsonUtil
 * @Description
 * @Author zhangzx
 * @Date 2019/7/20 14:53
 * Version 1.0
 **/
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);

    }
}
