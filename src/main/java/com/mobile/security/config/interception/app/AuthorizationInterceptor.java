package com.mobile.security.config.interception.app;

import com.mobile.security.base.IException;
import com.mobile.security.base.constants.enums.GeekExceptionMsg;
import com.mobile.security.base.jwt.AuthUtil;
import com.mobile.security.base.jwt.JwtConstants;
import com.mobile.security.utils.ToolUtils;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description TODO
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object)
            throws Exception {
        // 获取token的请求key=Authorization
        final String requestHeader = httpServletRequest.getHeader(JwtConstants.AUTH_HEADER);

        if (ToolUtils.isNotEmpty(requestHeader) && requestHeader.startsWith(JwtConstants.PREFIX)) {
            String authToken = requestHeader.substring(5);
            try {
                boolean isExpired = AuthUtil.isTokenExpired(authToken);
                if (isExpired) {
                    throw new IException(GeekExceptionMsg.TOKEN_CLIENT_ERROR);
                }
            } catch (JwtException e) {
                throw new IException(GeekExceptionMsg.TOKEN_SERVER_ERROR);
            }
            String app_key = AuthUtil.getUserNameFromToken(authToken);
            httpServletRequest.setAttribute("app_key", app_key);
            return Boolean.TRUE;
        }
        throw new IException(GeekExceptionMsg.TOKEN_CLIENT_ERROR);
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
