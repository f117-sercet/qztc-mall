package com.dsc.mall.demo.config;

import com.dsc.mall.config.BaseSwaggerConfig;
import com.dsc.mall.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * @Author:estic
 * @Date: 2021/4/30 11:13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.dsc.mall.demo.controller")
                .title("mall-demo系统")
                .description("SpringBoot版本中的一些示例")
                .contactName("estic")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
