package com.wxy.utils;

/**
 * @author wxy
 * @title: com.wxy.utils.ResultCode
 * @description: TODO
 * @date 2021/9/2218:24
 */
public enum ResultCode {
    SUCCESS(20000),
    ERROR(20001);
    private final int code;

    public int getCode() {
        return code;
    }

    ResultCode(int code) {
        this.code = code;
    }
}