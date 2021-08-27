package com.mobile.security.config.interception.web;

import com.mobile.security.base.IException;
import com.mobile.security.base.constants.SysConst;
import com.mobile.security.base.constants.enums.GeekExceptionMsg;
import com.mobile.security.base.jwt.AuthUtil;
import com.mobile.security.base.jwt.JwtConstants;
import com.mobile.security.model.vo.web.IUserVO;
import com.mobile.security.utils.ToolUtils;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/25 0:01
 * @Version v1.0
 * @Description TODO
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object)
            throws Exception {
        IUserVO user = (IUserVO) httpServletRequest.getSession().getAttribute(SysConst.USER_SESSION_KEY);
        if (ToolUtils.isEmpty(user)) {
            throw new IException(GeekExceptionMsg.USER_SESSION_EXPIRED);
        }
        return Boolean.TRUE;
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
