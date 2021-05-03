package com.dsc.mall.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 * @Author:estic
 * @Date: 2021/4/30 11:03
 */
@Configuration
@MapperScan("com.dsc.mall.mapper")
public class MyBatisConfig {
}
