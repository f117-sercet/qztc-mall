package com.dsc.portal.dao;

import com.dsc.mall.model.CmsSubject;
import com.dsc.mall.model.PmsBrand;
import com.dsc.mall.model.PmsProduct;
import com.dsc.portal.domain.FlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页内容Dao
 * @author 60221
 */
public interface HomeDao {
    /**
     * 获取推荐品牌
     * @param limit
     * @param offset
     * @return
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取秒杀商品
     * @param flashPromotionId
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * 获取新品推荐
     */
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);
    /**
     * 获取人气推荐
     */
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取推荐专题
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}


