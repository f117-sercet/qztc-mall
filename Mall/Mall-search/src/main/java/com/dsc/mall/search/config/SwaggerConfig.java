package com.dsc.mall.search.config;

import com.dsc.mall.config.BaseSwaggerConfig;
import com.dsc.mall.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * @Author:estic
 * @Date: 2021/2/28 16:56
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.dsc.mall.search.controller")
                .title("搜索系统")
                .description("mall相关接口文档")
                .contactName("dsc")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}
