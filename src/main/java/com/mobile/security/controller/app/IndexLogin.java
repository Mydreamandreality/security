package com.mobile.security.controller.app;

import com.mobile.security.base.constants.SysConst;
import com.mobile.security.base.constants.enums.GeekExceptionMsg;
import com.mobile.security.base.constants.response.ServiceResult;
import com.mobile.security.base.jwt.AuthUtil;
import com.mobile.security.model.dto.app.IAppAlarmDto;
import com.mobile.security.model.dto.app.IAppLoginDTO;
import com.mobile.security.model.dto.web.IAppDeviceDTO;
import com.mobile.security.model.vo.app.IAppLoginVO;
import com.mobile.security.service.impl.IAppAlarmServiceImpl;
import com.mobile.security.service.impl.IAppDeviceServiceImpl;
import com.mobile.security.utils.ToolUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description TODO
 */
@RestController
@RequestMapping(value = "/api/app")
@Api(value = "/api", tags = {"APP接口文档"})
public class IndexLogin {

    @Autowired
    private IAppAlarmServiceImpl appAlarmService;
    @Autowired
    private IAppDeviceServiceImpl appDeviceService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "APP登录接口", httpMethod = "POST", notes = "注意事项")
    public ServiceResult<IAppLoginVO> login(@RequestBody @Validated IAppLoginDTO loginDTO) {
        // 应该在数据库判断app_key是否存在，存在则生成token
        Boolean isAppKey = Boolean.TRUE;
        if (isAppKey) {
            String token = AuthUtil.generateToken(loginDTO.getAppKey());
            IAppLoginVO appLoginVO = new IAppLoginVO().setToken(token);
            return ServiceResult.success(appLoginVO);
        }
        return ServiceResult.failure(GeekExceptionMsg.APP_KEY_ERROR);
    }

    @PostMapping(value = "/security_alarm")
    @ApiOperation(value = "触发安全策略接口", httpMethod = "POST", notes = "请求参数 {eventType: SQL注入 or XSS注入 or 信息泄露}")
    public ServiceResult<String> recordSecurityAlarm(@RequestBody @Validated IAppAlarmDto alarmDto,
                                                     HttpServletRequest request) {
        String appKey = String.valueOf(request.getAttribute("app_key"));
        String requestIp = ToolUtils.getIPAddress(request);
        alarmDto.setAppKey(appKey).setRequestIp(requestIp);
        Boolean isSuccess = appAlarmService.recordAppSecurity(alarmDto);
        return ServiceResult.success(SysConst.CREATE_SUCCESS);
    }

    @PostMapping(value = "/active")
    @ApiOperation(value = "生成当前登录app设备信息", httpMethod = "POST", notes = "注意事项")
    public ServiceResult<String> recordSecurityActive(@RequestBody @Validated IAppDeviceDTO appDeviceDTO,
                                                      HttpServletRequest request) {
        String appKey = String.valueOf(request.getAttribute("app_key"));
        System.out.println(appKey);
        appDeviceDTO.setAppKey(appKey);
        Boolean isSuccess = appDeviceService.recordAppDetail(appDeviceDTO);
        return ServiceResult.success(SysConst.CREATE_SUCCESS);
    }
}
