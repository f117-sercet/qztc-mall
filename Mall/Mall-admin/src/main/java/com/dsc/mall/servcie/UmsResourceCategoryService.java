package com.dsc.mall.servcie;

import com.dsc.mall.model.UmsResourceCategory;

import java.util.List;

/**
 * 后台资源分类管理Service
 * @Author:estic
 * @Date: 2021/4/6 23:28
 */
public interface UmsResourceCategoryService {

    /**
     * 获取所有资源分类
     */
    List<UmsResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    int create(UmsResourceCategory umsResourceCategory);

    /**
     * 修改资源分类
     */
    int update(Long id, UmsResourceCategory umsResourceCategory);

    /**
     * 删除资源分类
     */
    int delete(Long id);
}
