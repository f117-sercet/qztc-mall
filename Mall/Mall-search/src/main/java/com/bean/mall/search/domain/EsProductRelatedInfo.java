package com.bean.mall.search.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 搜索商品相关品牌的名称，分类及属性
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EsProductRelatedInfo {
    private List<String> brandNames;
    private List<String> productCategoryNames;
    private List<ProductAttr> productAttrs;

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class ProductAttr {
        private Long attrId;
        private String attrName;
        private List<String> attrValues;
    }

}
