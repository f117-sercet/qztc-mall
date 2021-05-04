package com.dsc.mall.portal.domain;

import com.dsc.mall.model.PmsProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author 60221
 * 商品分类，包含子类
 */
@Getter
@Setter
public class PmsProductCategoryNode extends PmsProductCategory {
    private List<PmsProductCategoryNode> children;
}
