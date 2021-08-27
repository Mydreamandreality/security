package com.mobile.security.model.dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description APP登录
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "APP用户登录DTO", description = "APP登录需要请求的数据")
public class IAppLoginDTO {

    @NotBlank(message = "手机号为必填项")
    @Size(min = 11, max = 11, message = "手机号长度限制为11位")
    @ApiModelProperty(value = "手机号")
    private String phone;

    @NotBlank(message = "验证码为必填项")
    @Size(min = 6, max = 6, message = "验证码长度限制为6位")
    @ApiModelProperty(value = "验证码")
    private String verificationCode;

    @NotBlank(message = "APP标识为必填项")
    @ApiModelProperty(value = "APP标识")
    private String appKey;
}
