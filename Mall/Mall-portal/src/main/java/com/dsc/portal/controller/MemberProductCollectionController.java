package com.dsc.portal.controller;

import com.dsc.mall.api.CommonPage;
import com.dsc.mall.api.CommonResult;
import com.dsc.portal.domain.MemberProductCollection;
import com.dsc.portal.servcie.impl.MemberCollectionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 会员收藏管理Controller
 * @author 60221
 */
@Api(tags = "MemberCollectionController", description = "会员收藏管理")
@RequestMapping("/member/productCollection")
public class MemberProductCollectionController {
    @Autowired
    private MemberCollectionServiceImpl memberCollectionService;

    @ApiOperation("添加商品收藏")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody MemberProductCollection productCollection){
        int count = memberCollectionService.add(productCollection);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("显示收藏列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<MemberProductCollection>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<MemberProductCollection> page = memberCollectionService.List(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }
    @ApiOperation("删除收藏商品")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(long productId){

        int count = memberCollectionService.delete(productId);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
  @ApiOperation("显示收藏商品xx")
  @RequestMapping(value = "/detail",method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<MemberProductCollection> detail(@RequestParam Long productId){
        MemberProductCollection memberProductCollection = memberCollectionService.detail(productId);
        return CommonResult.success(memberProductCollection);
  }
    @ApiOperation("清空收藏列表")
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult clear() {
        memberCollectionService.clear();
        return CommonResult.success(null);
    }
}
