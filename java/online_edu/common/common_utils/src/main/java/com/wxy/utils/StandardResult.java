package com.wxy.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxy
 * @title: com.wxy.utils.StandardResult
 * @description: TODO
 * @date 2021/9/2218:36
 */
@ApiModel
@Data
public class StandardResult {
    @ApiModelProperty(value = "success or not")
    private Boolean success;
    @ApiModelProperty(value = "the status code of this result")
    private Integer code;
    @ApiModelProperty(value = "additional information of this result")
    private String message;
    @ApiModelProperty(value = "the actual data of this return")
    private Map<String, Object> data= new HashMap<>();

    private StandardResult(){}

    public static StandardResult ok(){
        StandardResult standardResult = new StandardResult();
        standardResult.setSuccess(true);
        standardResult.setCode(ResultCode.SUCCESS.getCode());
        standardResult.setMessage("ok");
        return standardResult;//链式编程
    }
    public static StandardResult error(){
        StandardResult standardResult = new StandardResult();
        standardResult.setSuccess(false);
        standardResult.setCode(ResultCode.ERROR.getCode());
        standardResult.setMessage("failed");
        return standardResult;
    }
    public StandardResult success(Boolean success){
        setSuccess(success);
        return this;
    }
    public StandardResult message(String message){
        setMessage(message);
        return this;
    }
    public StandardResult code(Integer code){
        setCode(code);
        return this;
    }
    public StandardResult data(Map<String, Object> data){
        setData(data);
        return this;
    }
    public StandardResult data(String key, Object value){
        data.put(key, value);
        return this;
    }
}
