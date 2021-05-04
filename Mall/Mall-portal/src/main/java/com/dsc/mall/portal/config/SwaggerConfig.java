package com.dsc.mall.portal.config;

import com.dsc.mall.config.BaseSwaggerConfig;
import com.dsc.mall.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author:estic
 * @Date: 2021/2/26 19:40
 * Swagger2API文档的配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.dsc.mall.portal.controller")
                .title("前台系统")
                .description("mall前台相关接口文档")
                .contactName("dsc")
                .version("1.0")
                .build();
    }
}
