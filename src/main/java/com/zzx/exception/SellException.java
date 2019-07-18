package com.zzx.exception;

import com.zzx.enums.ResultEnum;

import javax.persistence.Id;

/**
 * @ClassName SellException
 * @Description
 * @Author zhangzx
 * @Date 2019/7/17 15:00
 * Version 1.0
 **/
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super (resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
