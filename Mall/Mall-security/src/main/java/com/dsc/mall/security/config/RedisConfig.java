package com.dsc.mall.security.config;

import com.dsc.mall.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置类
 * @author 60221
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {
}
