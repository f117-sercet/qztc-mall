package com.dsc.mall.servcie;

import com.dsc.mall.model.SmsHomeBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页品牌管理Service
 * @Author:estic
 * @Date: 2021/3/27 22:24
 */
public interface SmsHoneBrandService {

    /**
     * 添加首页品牌推荐
     * @param homeBrandList
     * @return
     */

    @Transactional
    int create(List<SmsHomeBrand> homeBrandList);
}
