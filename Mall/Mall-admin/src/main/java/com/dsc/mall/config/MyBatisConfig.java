package com.dsc.mall.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis
 * @Author:estic
 * @Date: 2021/5/4 15:42
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.dsc.mall.mapper","com.dsc.mall.dao","com.dsc.mall"})
public class MyBatisConfig {
}
