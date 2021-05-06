package com.dsc.mall.config;

import com.dsc.mall.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * @Author:estic
 * @Date: 2021/5/4 15:46
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.dsc.mall.controller")
                .title("mall后台系统")
                .description("mall后台相关接口文档")
                .contactName("dsc")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
    }



