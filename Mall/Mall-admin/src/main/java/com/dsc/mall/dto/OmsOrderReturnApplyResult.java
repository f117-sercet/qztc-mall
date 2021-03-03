package com.dsc.mall.dto;

import com.dsc.mall.model.OmsCompanyAddress;
import com.dsc.mall.model.OmsOrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 * @Author:estic
 * @Date: 2021/3/3 21:48
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {

    @Getter
    @Setter
    @ApiModelProperty(value = "公司收货地址")
    private OmsCompanyAddress companyAddress;
}
