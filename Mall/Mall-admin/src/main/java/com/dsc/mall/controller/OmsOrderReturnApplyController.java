package com.dsc.mall.controller;

import com.dsc.mall.api.CommonPage;
import com.dsc.mall.api.CommonResult;
import com.dsc.mall.dto.OmsReturnApplyQueryParam;
import com.dsc.mall.dto.OmsUpdateStatusParam;
import com.dsc.mall.model.OmsOrderReturnApply;
import com.dsc.mall.servcie.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单退货申请管理Controller
 * @Author:estic
 * @Date: 2021/4/26 8:17
 */
@Controller
@Api(tags = "OmsOrderReturnApplyController", description = "订单退货申请管理")
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {

    @Autowired
    private OmsOrderReturnApplyService returnApplyService;

    @ApiOperation("分页查询退货申请")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrderReturnApply>> list(OmsReturnApplyQueryParam queryParam,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<OmsOrderReturnApply> returnApplyList = returnApplyService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(returnApplyList));
    }
    @ApiOperation("批量删除退货申请")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = returnApplyService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
        @ApiOperation("修改退货申请状态")
        @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
        @ResponseBody
        public CommonResult updateStatus(@PathVariable Long id, @RequestBody OmsUpdateStatusParam statusParam) {

            int count = returnApplyService.updateStatus(id, statusParam);
            if (count > 0) {
                return CommonResult.success(count);
            }
            return CommonResult.failed();
        }
    }
