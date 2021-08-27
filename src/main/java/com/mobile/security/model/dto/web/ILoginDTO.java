package com.mobile.security.model.dto.web;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/25 21:33
 * @Version v1.0
 * @Description TODO
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "WEB用户登录DTO", description = "用户登录请求所需数据")
public class ILoginDTO {

    @NotBlank(message = "用户名称为必填项")
    private String username;

    @NotBlank(message = "用户密码为必填项")
    private String password;

    @NotBlank(message = "验证码为必填项")
    private String verification_code;
}
