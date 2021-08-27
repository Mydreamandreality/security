package com.mobile.security.controller;


import com.mobile.security.base.constants.response.ServiceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description 新疆电科院-移动安全实验室-自检
 */
@RestController
@RequestMapping(value = "/api", name = "Index-自检接口文档")
@Api(value = "/api", tags = {"Index"})
public class IndexController {


    @GetMapping(value = "/index")
    @ApiOperation(value = "自检接口", httpMethod = "GET", notes = "注意事项")
    public ServiceResult<String> login() {
        return ServiceResult.success("Welcome");
    }
}
