package com.dsc.mall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 * @Author:estic
 * @Date: 2021/2/28 16:55
 */
@Configuration
@MapperScan({"com.dsc.mall.mapper","com.dsc.mall.search.dao"})
public class MyBatisConfig {
}
