package com.dsc.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 全局跨域相关配置
 * @Author:estic
 * @Date: 2021/2/23 22:04
 */
@Configuration
public class GlobalCorsConfig {
/**
 * 允许跨域调用的过滤器
 */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        //允许所有域名进行跨域调用
        configuration.addAllowedOrigin("*");
        //允许跨越发送cookie
        configuration.setAllowCredentials(true);
        //放行全部原始头信息
        configuration.addAllowedHeader("*");
        //允许所有请求方法跨域调用
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }

}
