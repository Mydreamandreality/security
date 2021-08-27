package com.mobile.security.model.dto.web;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/25 18:22
 * @Version v1.0
 * @Description TODO
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "App新增DTO", description = "新增APP请求所需数据")
public class IAppDTO {

    @NotBlank(message = "应用名称为必填项")
    private String appName;

    @NotBlank(message = "应用Key为必填项")
    @Size(min = 16, max = 16, message = "应用key长度必须为16位")
    private String appKey;

    @NotBlank(message = "联系人为必填项")
    private String person;
}
