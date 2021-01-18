package com.dsc.mall.demo.controller;

import com.dsc.mall.demo.servcie.DemoService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 品牌管理
 * @author 60221
 */
@Controller
@Api(tags = "DemoController", description = "品牌管理示例接口")
public class DemoController {
    @Autowired
    private DemoService demoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);


}
