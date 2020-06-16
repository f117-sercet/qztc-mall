package com.bean.mall.portal.domain;

import com.bean.model.CmsSubject;
import com.bean.model.PmsBrand;
import com.bean.model.PmsProduct;
import com.bean.model.SmsHomeAdvertise;

import java.util.List;

/**
 * 首页内容返回信息封装
 */
public class HomeContentResult {
    //轮播广告
    private List<SmsHomeAdvertise> advertiseList;
    //推荐品牌
    private List<PmsBrand> brandList;
    //当前秒杀场次
    private HomeFlashPromotion homeFlashPromotion;
    //新品推荐
    private List<PmsProduct> newProductList;
    //人气推荐
    private List<PmsProduct> hotProductList;
    //推荐专题
    private List<CmsSubject> subjectList;
}
