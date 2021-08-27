package com.mobile.security.model.dto.web;

import com.mobile.security.base.constants.RegexpConst;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description TODO
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "创建用户DTO", description = "创建用户请求所需数据")
public class IUserDTO {

    @NotBlank(message = "用户昵称为必填项")
    private String username;

    @NotBlank(message = "登录邮箱为必填项")
    @Email(message = "登录邮箱格式错误")
    private String email;

    @NotBlank(message = "登录密码为必填项")
    @Pattern(regexp = RegexpConst.PASSWORD_REGEXP, message = "密码必须由数字+字母组成,长度6-10位")
    private String password;

    /**
     * 确认密码
     */
    @NotBlank(message = "再次输入密码为必填项")
    @Pattern(regexp = RegexpConst.PASSWORD_REGEXP, message = "密码必须由数字+字母组成,长度6-10位")
    private String confirmPassword;
}
