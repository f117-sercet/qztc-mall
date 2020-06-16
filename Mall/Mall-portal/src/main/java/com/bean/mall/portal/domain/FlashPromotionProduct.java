package com.bean.mall.portal.domain;

import com.bean.model.PmsProduct;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 秒杀信息和商品对象封装
 */
public class FlashPromotionProduct extends PmsProduct {
    @Getter
    @Setter
    private BigDecimal flashPromotionPrice;
    private Integer flashPromotionCount;
    private Integer flashPromotionLimit;
}
