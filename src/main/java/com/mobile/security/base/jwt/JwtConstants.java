package com.mobile.security.base.jwt;

/**
 * JWT常量
 */
public interface JwtConstants {

    /**
     * HTTPHeader请求的参数
     */
    String AUTH_HEADER = "Authorization";

    /**
     * 加密算法
     */
    String SECRET = "defaultSecret";

    /**
     * 自定义前缀
     */
    String PREFIX = "mock ";

    /**
     * APP验证接口
     */
    String APP_AUTH_PATH = "/api/app/login";

    /**
     * WEB验证接口
     */
    String WEB_AUTH_PATH = "/api/web/login";

    /**
     * 验证码接口
     */
    String VERIFICATION_CODE_PATH = "/api/web/verification_code";

    /**
     * SWAGGER接口
     */
    String SWAGGER_PATH = "/swagger-ui.html";

    /**
     * JWT过期时间
     */
    Long EXPIRATION = 604800L;
}
