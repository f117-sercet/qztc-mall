package com.bean.mall.portal.controller;

import com.bean.mall.common.api.CommonResult;
import com.bean.mall.portal.domain.HomeContentResult;
import com.bean.mall.portal.service.HomeService;
import com.bean.model.PmsProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public CommonResult<HomeContentResult> content(){
        HomeContentResult contentResult=homeService.content();
        return CommonResult.success(contentResult);

    }
@ApiOperation("分页获取推荐")
@RequestMapping(value = "/recommendProductList",method = RequestMethod.GET)
@ResponseBody
public CommonResult<List<PmsProduct>> recommendProductList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
    List<PmsProduct> productList = homeService.recommendProductList(pageSize, pageNum);
    return CommonResult.success(productList);
}


}
