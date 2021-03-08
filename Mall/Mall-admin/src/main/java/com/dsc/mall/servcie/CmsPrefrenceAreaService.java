package com.dsc.mall.servcie;

import com.dsc.mall.model.CmsPrefrenceArea;

import java.util.List;

/**
 * 商品优选管理Service
 * @Author:estic
 * @Date: 2021/3/8 22:08
 */
public interface CmsPrefrenceAreaService {
    /**
     * 读取所有优选专区
     * @return
     */
    List<CmsPrefrenceArea> listAll();
}
