package com.dsc.portal.domain;

import com.dsc.mall.model.PmsProduct;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author 60221
 * 秒杀信息和商品信息
 */
@Getter
@Setter
public class FlashPromotionProduct extends PmsProduct {
    private BigDecimal flashPromotionPrice;
    private Integer flashPromotionCount;
    private Integer flashPromotionLimit;
}
