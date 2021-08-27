package com.mobile.security.base.constants.enums;

import com.mobile.security.utils.SnowFlake;
import org.springframework.http.HttpStatus;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description 异常信息内容
 */
public enum GeekExceptionMsg {

    SERVER_ERROR(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "InternalServerError"),

    SERVICE_ERROR(String.valueOf(HttpStatus.BAD_REQUEST.value()), "ServiceErrorMsg"),

    ES_INIT_ERROR(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "InitIoError"),

    BAD_REQUEST_ERROR(String.valueOf(HttpStatus.BAD_REQUEST.value()), "RequestParamError"),

    APP_KEY_ERROR(String.valueOf(HttpStatus.BAD_REQUEST.value()), "未经过验证的app_key"),

    TOKEN_SERVER_ERROR(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Token验证时发生内部异常"),

    TOKEN_CLIENT_ERROR(String.valueOf(HttpStatus.BAD_REQUEST.value()), "错误的Token,请检查"),

    REMOVE_SYS_USER(String.valueOf(HttpStatus.BAD_REQUEST.value()), "默认系统管理员无法删除"),

    PASSWORD_WRONG(String.valueOf(HttpStatus.BAD_REQUEST.value()), "请检查密码,两次输入不一致"),

    EMAIL_EXIST(String.valueOf(HttpStatus.BAD_REQUEST.value()), "当前输入邮箱已经存在,请重新输入"),

    USERNAME_EXIST(String.valueOf(HttpStatus.BAD_REQUEST.value()), "当前用户名称已经存在,请重新输入"),

    CODE_WRONG(String.valueOf(HttpStatus.BAD_REQUEST.value()), "验证码错误,请重新输入"),

    USER_OR_PWD_WRONG(String.valueOf(HttpStatus.BAD_REQUEST.value()), "用户名或者密码错误,请重新输入"),

    OLD_PWD_WRONG(String.valueOf(HttpStatus.BAD_REQUEST.value()), "原密码错误,请重新输入"),

    TWO_PWD_WRONG(String.valueOf(HttpStatus.BAD_REQUEST.value()), "两次密码输入不一致,请重新输入"),

    USER_SESSION_EXPIRED(String.valueOf(HttpStatus.UNAUTHORIZED.value()), "登录信息已经过期,请重新登录"),

    REMOVE_EMPTY(String.valueOf(HttpStatus.UNAUTHORIZED.value()), "当前请求数据不存在,请重新输入"),

    REMOVE_EMPTY_USER(String.valueOf(HttpStatus.BAD_REQUEST.value()), "当前操作用户不存在");

    private String code;

    private String message;


    GeekExceptionMsg(String code, String message) {
        this.code = code;
        this.message = message;

    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
