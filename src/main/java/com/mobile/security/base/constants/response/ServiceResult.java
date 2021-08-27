package com.mobile.security.base.constants.response;

import com.mobile.security.base.constants.enums.GeekExceptionMsg;
import com.mobile.security.utils.SnowFlake;

import java.io.Serializable;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description 业务Response
 */
public class ServiceResult<T> implements Serializable {

    private static final long serialVersionUID = 3871677341680489494L;

    private boolean success = false;

    private String code;

    private String message;

    private String requestId;

    private T result;

    private ServiceResult() {
    }

    public static <T> ServiceResult<T> success(T result) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = true;
        item.result = result;
        item.code = "200";
        item.message = "success";
        item.requestId = SnowFlake.nextId();
        return item;
    }

    public static <T> ServiceResult<T> failure(String errorCode, String errorMessage) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.code = errorCode;
        item.message = errorMessage;
        item.requestId = SnowFlake.nextId();
        return item;
    }

    public static <T> ServiceResult<T> failure(GeekExceptionMsg exceptionMsg) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.code = String.valueOf(exceptionMsg.getCode());
        item.message = exceptionMsg.getMessage();
        item.requestId = SnowFlake.nextId();
        return item;
    }

    public boolean hasResult() {
        return result != null;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
