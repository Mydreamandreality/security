package com.mobile.security.model.vo.web;

import com.mobile.security.base.constants.RegexpConst;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/24 18:07
 * @Version v1.0
 * @Description TODO
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "用户登录成功VO", description = "登录成功后所需的数据")
public class IUserVO {

    private Integer id;

    private String username;

    private String email;

    private String role;
}
