package com.mobile.security.base.constants;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description 常用正则
 */
public interface RegexpConst {

    /**
     * 密码正则: 必须包含数字和字母,长度6-10位
     */
    String PASSWORD_REGEXP = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$";
}
