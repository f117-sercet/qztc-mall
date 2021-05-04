package com.dsc.mall.portal.controller;

import com.dsc.mall.api.CommonPage;
import com.dsc.mall.api.CommonResult;
import com.dsc.mall.portal.domain.MemberBrandAttention;
import com.dsc.mall.portal.servcie.MemberAttentionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 会员关注品牌管理Controller
 * @author 60221
 */
@Controller
@Api(tags = "MemberAttentionController", description = "会员关注品牌管理")
@RequestMapping("/member/attention")
public class MemberAttentionController {
    @Autowired
    private MemberAttentionService memberAttentionService;

    @ApiOperation("添加品牌关注")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody MemberBrandAttention memberBrandAttention) {

        int count = memberAttentionService.add(memberBrandAttention);
        if (count>0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("显示关注列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<MemberBrandAttention>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<MemberBrandAttention> page = memberAttentionService.list(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }
    @ApiOperation("显示关注品牌详情")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<MemberBrandAttention> detail(@RequestParam Long brandId) {
        MemberBrandAttention memberBrandAttention = memberAttentionService.detail(brandId);
        return CommonResult.success(memberBrandAttention);
    }
    @ApiOperation("清空关注列表")
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult clear() {
        memberAttentionService.clear();
        return CommonResult.success(null);
    }
}
