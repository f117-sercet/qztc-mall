package com.dsc.portal.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 首页当前秒杀场次信息
 * @author 60221
 */
@Getter
@Setter
public class HomeFlashPromotion {
    private Date startTime;
    private Date endTime;
    private Date nextStartTime;
    /**
     * 属于该秒杀活动的商品
     */
    private List<FlashPromotionProduct> productList;
}
