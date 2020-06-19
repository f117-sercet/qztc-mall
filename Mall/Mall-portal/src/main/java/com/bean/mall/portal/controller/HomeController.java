package com.bean.mall.portal.controller;

import com.bean.mall.portal.domain.HomeContentResult;
import com.bean.mall.portal.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页内容管理Controller
 */
@Controller
@@Api(tags = "HomeController", description = "首页内容管理")
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;
    @ApiOperation("首页内容页信息展示")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseBody
    public  CommonResult<HomeContentResult>  content(){

    }



}
