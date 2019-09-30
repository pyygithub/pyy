package com.thtf.generator.common.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * ========================
 * 统一响应结果集
 * Author：pyy
 * Date：2019/6/6
 * Time：10:10
 * Version: v1.0
 * ========================
 */
@Data
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Result<T> {

    //操作代码
    int code;

    //提示信息
    String msg;

    //结果数据
    T data;

    public Result(ResultCode resultCode){
        this.code = resultCode.code();
        this.msg = resultCode.message();
    }

    public Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultCode resultCode, T data){
        this.code = resultCode.code();
        this.msg = resultCode.message();
        this.data = data;
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }

    public static <T> Result SUCCESS(T data){
        return new Result(ResultCode.SUCCESS, data);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }

}
