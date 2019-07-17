package com.zzx.VO;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @Description http请求返回给前端的对象
 * @Author zhangzx
 * @Date 2019/7/17 9:37
 * Version 1.0
 **/
@Data
public class ResultVO<T> {

    // 错误码
    private Integer code;

    // 提示信息
    private String msg;

    // 具体内容
    private T data;
}
