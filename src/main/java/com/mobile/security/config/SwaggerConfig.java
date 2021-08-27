package com.mobile.security.config;

import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description 新疆电科院-移动安全实验室
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "my-config", name = "swagger-ui-open", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        System.out.println("新疆电科院-移动安全实验室-接口文档地址: http://127.0.0.1:8000/swagger-ui.html");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(this.getParameter());
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("新疆电科院-移动安全实验室-接口文档")
                .description("Rest API接口")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

    public List<Parameter> getParameter() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization")
                .description("Token令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue("mock ")
                .required(false)
                .build();
        pars.add(tokenPar.build());
        return pars;
    }
}