package com.dsc.mall.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author 60221
 * 启动器
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.dsc.mall.mapper")
public class MallApplication {

    public static void main(String[] args) {

        SpringApplication.run(MallApplication.class,args);
    }
}
