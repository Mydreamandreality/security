package com.mobile.security.controller.web;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.mobile.security.base.constants.SysConst;
import com.mobile.security.base.constants.enums.GeekExceptionMsg;
import com.mobile.security.base.constants.response.ServiceResult;
import com.mobile.security.model.dto.web.ILoginDTO;
import com.mobile.security.model.vo.web.IUserVO;
import com.mobile.security.service.impl.IWebUserServiceImpl;
import com.mobile.security.utils.ToolUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/24 22:42
 * @Version v1.0
 * @Description TODO
 */
@RestController
@RequestMapping(value = "/api/web")
@Api(value = "/api/web", tags = {"WEB-登录管理-接口文档"})
public class LoginController {

    @Autowired
    private Producer producer;

    @Autowired
    private IWebUserServiceImpl userService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "WEB登录接口", httpMethod = "POST", notes = "注意事项")
    public ServiceResult<IUserVO> login(@RequestBody @Validated ILoginDTO loginDTO, HttpServletRequest request) {
        String code = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!ToolUtils.equals(loginDTO.getVerification_code(), SysConst.MOCK)) {
            if (!loginDTO.getVerification_code().equalsIgnoreCase(code)) {
                return ServiceResult.failure(GeekExceptionMsg.CODE_WRONG);
            }
        }
        IUserVO userVO = userService.loginInfoIsItCorrect(loginDTO.getUsername(), loginDTO.getPassword());
        if (userVO.getId() == 0) {
            return ServiceResult.failure(GeekExceptionMsg.USER_OR_PWD_WRONG);
        }
        request.getSession().setAttribute(SysConst.USER_SESSION_KEY, userVO);
        return ServiceResult.success(userVO);
    }

    @PostMapping(value = "/login_out")
    @ApiOperation(value = "WEB退出登录接口", httpMethod = "POST", notes = "注意事项")
    public ServiceResult loginOut(HttpServletRequest request) {
        //清Session
        request.getSession().removeAttribute(SysConst.USER_SESSION_KEY);
        return ServiceResult.success(SysConst.LOGIN_OUT_SUCCESS);
    }

    @GetMapping(value = "/this_user")
    @ApiOperation(value = "获取当前登录用户信息", httpMethod = "GET", notes = "注意事项")
    public ServiceResult<IUserVO> thisUser(HttpServletRequest request) {
        try {
            IUserVO userVO = (IUserVO) request.getSession().getAttribute(SysConst.USER_SESSION_KEY);
            if (ToolUtils.isNotEmpty(userVO)) {
                return ServiceResult.success(userVO);
            }
            return ServiceResult.failure(GeekExceptionMsg.USER_SESSION_EXPIRED);
        } catch (Exception e) {
            return ServiceResult.failure(GeekExceptionMsg.USER_SESSION_EXPIRED);
        }
    }

    @GetMapping(value = "/verification_code")
    @ApiOperation(value = "生成验证码", httpMethod = "GET", notes = "注意事项")
    public void verification_code(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        response.setDateHeader("Expires", 0);

        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");

        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        // return a jpeg
        response.setContentType("image/jpeg");

        // create the text for the image
        String capText = producer.createText();

        // store the text in the session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        // create the image with the text
        BufferedImage bi = producer.createImage(capText);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write the data out
        try {
            ImageIO.write(bi, "jpg", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
