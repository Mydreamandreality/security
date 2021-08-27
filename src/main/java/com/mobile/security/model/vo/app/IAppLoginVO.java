package com.mobile.security.model.vo.app;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description 登录VO
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "APP用户登录VO", description = "APP登录返回的数据")
public class IAppLoginVO {

    /**
     * 客户端请求所需的Token
     */
    private String token;
}
