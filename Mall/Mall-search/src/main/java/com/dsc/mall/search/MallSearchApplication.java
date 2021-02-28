package com.dsc.mall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author:estic
 * @Date: 2021/2/27 11:29
 */
@SpringBootApplication(scanBasePackages = "com.dsc.mall")
public class MallSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallSearchApplication.class, args);
    }
}
