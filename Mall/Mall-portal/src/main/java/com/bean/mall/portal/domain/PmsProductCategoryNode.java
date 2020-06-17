package com.bean.mall.portal.domain;

import com.bean.model.PmsProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
/**
 * 商品分类，包含子分类
 */
public class PmsProductCategoryNode extends PmsProductCategory {
    private List<PmsProductCategoryNode> children;
}
