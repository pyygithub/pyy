package com.thtf.generator.common.exception;



import com.thtf.generator.common.response.ResultCode;
import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;

/**
 * 自定义异常类型
 * @author pyy
 */
@Setter
@Getter
public class CustomException extends RuntimeException {

    //错误代码
    private ResultCode resultCode;

    private int code;

    private String message;

    public CustomException(ResultCode resultCode){
        super(resultCode.message());
        this.resultCode = resultCode;
    }

    public CustomException(ResultCode resultCode, Object... args){
        code = resultCode.code();
        message = MessageFormat.format(resultCode.message(), args);
    }

}
