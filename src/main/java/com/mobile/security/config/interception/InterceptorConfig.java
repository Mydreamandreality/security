package com.mobile.security.config.interception;

import com.mobile.security.base.jwt.JwtConstants;
import com.mobile.security.config.interception.app.AuthorizationInterceptor;
import com.mobile.security.config.interception.web.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 18:45
 * @Version v1.0
 * @Description TODO
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] swaggerExcludes = new String[]{"/swagger-ui.html", "/swagger-resources/**", "/webjars/**"};
        //自定义去除的路径
        String[] appExcludes = new String[]{JwtConstants.APP_AUTH_PATH};
        String[] webExcludes = new String[]{JwtConstants.WEB_AUTH_PATH, JwtConstants.VERIFICATION_CODE_PATH};

        registry.addInterceptor(authenticationInterceptor())
                // addPathPatterns 用于添加拦截规则
                .addPathPatterns("/api/app/*")
                //自己定义的不拦截的规则
                .excludePathPatterns(appExcludes)
                //去除拦截springboot的静态文件
                .excludePathPatterns("/html/*")
                .excludePathPatterns("/demo")
                .excludePathPatterns("/")
                .excludePathPatterns("/error")
                .excludePathPatterns(swaggerExcludes);

        registry.addInterceptor(loginInterceptor())
                // addPathPatterns 用于添加拦截规则
                .addPathPatterns("/api/weba/*")
                //自己定义的不拦截的规则
                .excludePathPatterns(webExcludes);


        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /**
     * APP登录拦截
     *
     * @return
     */
    @Bean
    public AuthorizationInterceptor authenticationInterceptor() {
        return new AuthorizationInterceptor();
    }

    /**
     * WEB登录拦截
     *
     * @return
     */
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }
}
