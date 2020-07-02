package com.bean.mall.portal.domain;

import com.bean.model.PmsProductCategory;
import java.util.List;


/**
 * 商品分类，包含子分类
 */
public class PmsProductCategoryNode extends PmsProductCategory {
    private List<PmsProductCategoryNode> children;

    public PmsProductCategoryNode() {
    }

    public PmsProductCategoryNode(List<PmsProductCategoryNode> children) {
        this.children = children;
    }

    public List<PmsProductCategoryNode> getChildren() {
        return children;
    }

    public void setChildren(List<PmsProductCategoryNode> children) {
        this.children = children;
    }
}
