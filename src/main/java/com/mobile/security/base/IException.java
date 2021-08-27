package com.mobile.security.base;

import com.mobile.security.base.constants.enums.GeekExceptionMsg;
import org.springframework.http.HttpStatus;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description 自定义异常
 */
public class IException extends RuntimeException {
    private String code;

    private String message;

    public IException(GeekExceptionMsg geekExceptionMsg) {
        this.code = geekExceptionMsg.getCode();
        this.message = geekExceptionMsg.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
