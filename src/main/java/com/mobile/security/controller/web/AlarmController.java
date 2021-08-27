package com.mobile.security.controller.web;

import com.github.pagehelper.PageInfo;
import com.mobile.security.base.constants.response.ServiceResult;
import com.mobile.security.model.po.web.IAlarmPO;
import com.mobile.security.service.impl.IWebAlarmServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/27 19:04
 * @Version v1.0
 * @Description TODO
 */
@RestController
@RequestMapping(value = "/api/web")
@Api(value = "/api/web", tags = {"WEB-漏洞信息管理-接口文档"})
public class AlarmController {

    @Autowired
    private IWebAlarmServiceImpl alarmService;

    @GetMapping(value = "/alarms")
    @ApiOperation(value = "获取应用漏洞接口", httpMethod = "GET", notes = "全局复用接口")
    public ServiceResult<PageInfo<IAlarmPO>> getApplication(@RequestParam(value = "page_num") Integer pageNum,
                                                            @RequestParam(value = "page_size") Integer pageSize,
                                                            @RequestParam(required = false, value = "app_key") String appKey,
                                                            @RequestParam(required = false, value = "alarm_type") String alarmType,
                                                            @RequestParam(required = false, value = "start_time") Date startTime,
                                                            @RequestParam(required = false, value = "end_time") Date endTime) {
        PageInfo<IAlarmPO> appResult =
                alarmService.getAllAlarmCondition(pageNum, pageSize, alarmType, appKey, startTime, endTime);
        return ServiceResult.success(appResult);
    }

    @GetMapping(value = "/alarm")
    @ApiOperation(value = "获取应用漏洞详情接口", httpMethod = "GET", notes = "通过ID获取漏洞信息详情")
    public ServiceResult<IAlarmPO> getApplication(@RequestParam(value = "id") Integer id) {
        IAlarmPO appResult = alarmService.getAlarmById(id);
        return ServiceResult.success(appResult);
    }
}
