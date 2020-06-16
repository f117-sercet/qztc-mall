package com.bean.mall.portal.dao;

import com.bean.model.PmsBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页内容
 */
public interface HomeDao {

/**
 * 获取推荐品牌
 */
 List<PmsBrand> getRecomendBrand(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取秒杀商品
     */
    List<FlashPromo>

}
