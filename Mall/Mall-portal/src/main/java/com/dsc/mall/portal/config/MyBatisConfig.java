package com.dsc.mall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author:estic
 * @Date: 2021/2/25 23:25
 * MyBatis相关配置
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.dsc.mall.mapper","com.dsc.mall.portal.dao"})
public class MyBatisConfig {
}
