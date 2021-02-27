package com.dsc.portal.domain;

import com.dsc.mall.model.CmsSubject;
import com.dsc.mall.model.PmsBrand;
import com.dsc.mall.model.PmsProduct;
import com.dsc.mall.model.SmsHomeAdvertise;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * 首页内容通知
 * @author 60221
 */
@Getter
@Setter
public class HomeContentResult {
    /**
     * 轮播广告
     */
    private List<SmsHomeAdvertise> advertiseList;
    /**
     * 推荐品牌
     */
    private List<PmsBrand> brandList;
    /**
     * 当场秒杀场次
     */
    private HomeFlashPromotion homeFlashPromotion;
    /**
     * 新品推荐
     */
    private List<PmsProduct> newProductlist;
    /**
     * 人气推荐
     */
    private List<PmsProduct> hotProductList;
    /**
     * 推荐专题
     */
    private List<CmsSubject> subjectList;

}
