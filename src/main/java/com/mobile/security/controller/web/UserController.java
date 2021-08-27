package com.mobile.security.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.mobile.security.base.constants.SysConst;
import com.mobile.security.base.constants.enums.GeekExceptionMsg;
import com.mobile.security.base.constants.response.ServiceResult;
import com.mobile.security.model.dto.web.IPwdDTO;
import com.mobile.security.model.dto.web.IUserDTO;
import com.mobile.security.model.po.web.IAppManagerPO;
import com.mobile.security.model.po.web.IUserPO;
import com.mobile.security.service.impl.IWebUserServiceImpl;
import com.mobile.security.utils.ToolUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description TODO
 */
@RestController
@RequestMapping(value = "/api/web")
@Api(value = "/api/web", tags = {"WEB-用户管理-接口文档"})
public class UserController {

    @Autowired
    private IWebUserServiceImpl iUserService;

    @GetMapping(value = "/users")
    @ApiOperation(value = "用户列表接口", httpMethod = "GET", notes = "注意事项")
    public ServiceResult<PageInfo<IUserPO>> getAllUser(@RequestParam(value = "page_num") Integer pageNum,
                                                       @RequestParam(value = "page_size") Integer pageSize) {
        PageInfo<IUserPO> userResult = iUserService.getAllUser(pageNum, pageSize);
        return ServiceResult.success(userResult);
    }

    @DeleteMapping(value = "/user")
    @ApiOperation(value = "删除用户接口", httpMethod = "DELETE", notes = "注意事项")
    public ServiceResult<String> removeUser(@RequestParam(value = "id") Integer id) {
        IUserPO isExist = iUserService.getOne(new QueryWrapper<IUserPO>().eq("id", id));
        if (ToolUtils.isNotEmpty(isExist)) {
            iUserService.removeUserById(id);
            return ServiceResult.success(SysConst.REMOVE_SUCCESS);
        }
        return ServiceResult.failure(GeekExceptionMsg.REMOVE_EMPTY);
    }

    @PostMapping(value = "/user")
    @ApiOperation(value = "创建用户接口", httpMethod = "POST", notes = "密码长度为6-11位的字母+数字组合|邮箱不可以重复")
    public ServiceResult<String> createUser(@RequestBody @Validated IUserDTO userDTO) {
        iUserService.createUser(userDTO);
        return ServiceResult.success(SysConst.CREATE_SUCCESS);
    }

    @PostMapping(value = "/password")
    @ApiOperation(value = "密码更新接口", httpMethod = "POST", notes = "密码长度为6-11位的字母+数字组合|邮箱不可以重复")
    public ServiceResult<String> changePassword(@RequestBody @Validated IPwdDTO pwdDTO) {
        Boolean isSuccess = iUserService.changePassword(pwdDTO);
        return ServiceResult.success(SysConst.UPDATE_SUCCESS);
    }
}
