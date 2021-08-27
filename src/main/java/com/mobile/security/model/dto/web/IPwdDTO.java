package com.mobile.security.model.dto.web;

import com.mobile.security.base.constants.RegexpConst;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/25 0:33
 * @Version v1.0
 * @Description TODO
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "修改密码DTO", description = "修改密码请求所需数据")
public class IPwdDTO {

    @NotNull(message = "用户ID为必填项")
    private Integer id;

    @NotBlank(message = "原密码为必填项")
    @Pattern(regexp = RegexpConst.PASSWORD_REGEXP, message = "密码必须由数字+字母组成,长度6-10位")
    private String oldPassword;

    @NotBlank(message = "新密码为必填项")
    @Pattern(regexp = RegexpConst.PASSWORD_REGEXP, message = "密码必须由数字+字母组成,长度6-10位")
    private String newPassword;

    @NotBlank(message = "新密码为必填项")
    @Pattern(regexp = RegexpConst.PASSWORD_REGEXP, message = "密码必须由数字+字母组成,长度6-10位")
    private String confirmNewPassword;
}
