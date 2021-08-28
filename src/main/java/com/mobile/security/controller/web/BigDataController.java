package com.mobile.security.controller.web;

import com.mobile.security.base.constants.response.ServiceResult;
import com.mobile.security.service.impl.IAppBigServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/28 23:46
 * @Version v1.0
 * @Description TODO
 */
@RestController
@RequestMapping(value = "/api/web")
@Api(value = "/api/web", tags = {"WEB-大屏展示-接口文档"})
public class BigDataController {

    @Autowired
    private IAppBigServiceImpl bigService;

    @GetMapping(value = "/big_screen/statistics")
    @ApiOperation(value = "大屏统计接口", httpMethod = "GET", notes = "注意事项")
    public ServiceResult<Map<String, List<Map<String, Integer>>>> big_screen() {
        return ServiceResult.success(bigService.getBigData());
    }

    @GetMapping(value = "/device/statistics")
    @ApiOperation(value = "设备数统计", httpMethod = "GET", notes = "注意事项")
    public ServiceResult<Map<String, Integer>> statistics() {
        return ServiceResult.success(bigService.getDeviceCount());
    }

    @GetMapping(value = "/alarm/statistics")
    @ApiOperation(value = "漏洞总量统计", httpMethod = "GET", notes = "注意事项")
    public ServiceResult<List<Map<String, Integer>>> statistics(@RequestParam(required = false, value = "app_key") String appKey,
                                                                @RequestParam(required = false, value = "start_time") Date startTime,
                                                                @RequestParam(required = false, value = "end_time") Date endTime) {
        return ServiceResult.success(bigService.getAlarmCount(appKey, startTime, endTime));
    }
}
