package com.mobile.security.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.mobile.security.base.constants.SysConst;
import com.mobile.security.base.constants.enums.GeekExceptionMsg;
import com.mobile.security.base.constants.response.ServiceResult;
import com.mobile.security.model.dto.web.IAppDTO;
import com.mobile.security.model.po.web.IAppDevicePO;
import com.mobile.security.model.po.web.IAppManagerPO;
import com.mobile.security.service.impl.IAppDeviceServiceImpl;
import com.mobile.security.service.impl.IWebAppServiceImpl;
import com.mobile.security.utils.ToolUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/24 22:32
 * @Version v1.0
 * @Description TODO
 */
@RestController
@RequestMapping(value = "/api/web")
@Api(value = "/api/web", tags = {"WEB-应用管理-接口文档"})
public class ApplicationController {

    @Autowired
    private IWebAppServiceImpl appService;
    @Autowired
    private IAppDeviceServiceImpl appDeviceService;

    @GetMapping(value = "/application")
    @ApiOperation(value = "获取应用列表接口", httpMethod = "GET", notes = "注意事项")
    public ServiceResult<PageInfo<IAppManagerPO>> getApplication(@RequestParam(value = "page_num") Integer pageNum,
                                                                 @RequestParam(value = "page_size") Integer pageSize) {
        PageInfo<IAppManagerPO> appResult = appService.getAllApp(pageNum, pageSize);
        return ServiceResult.success(appResult);
    }

    @PostMapping(value = "/application")
    @ApiOperation(value = "新增应用列表接口", httpMethod = "POST", notes = "注意事项")
    public ServiceResult<String> addApplication(@RequestBody @Validated IAppDTO appDTO) {
        Boolean result = appService.addAppInfo(appDTO);
        return ServiceResult.success(SysConst.CREATE_SUCCESS);
    }

    @DeleteMapping(value = "/application")
    @ApiOperation(value = "删除应用接口", httpMethod = "DELETE", notes = "注意事项")
    public ServiceResult<String> removeApplication(@RequestParam(value = "app_key") String appKey) {
        IAppManagerPO isExist = appService.getOne(new QueryWrapper<IAppManagerPO>().eq("app_key", appKey));
        if (ToolUtils.isNotEmpty(isExist)) {
            Boolean result = appService.deleteAppInfo(appKey);
            return ServiceResult.success(SysConst.REMOVE_SUCCESS);
        }
        return ServiceResult.failure(GeekExceptionMsg.REMOVE_EMPTY);
    }

    @GetMapping(value = "/active")
    @ApiOperation(value = "获取应用登录设备详情接口", httpMethod = "GET", notes = "注意事项")
    public ServiceResult<IAppDevicePO> getApplicationDevice(@RequestParam(value = "app_key") String appKey) {
        IAppDevicePO iAppDevicePO = appDeviceService.getAppDetailByAppKey(appKey);
        return ServiceResult.success(iAppDevicePO);
    }
}
