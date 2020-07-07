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

    public EsProductRelatedInfo() {
    }

    public List<String> getBrandNames() {
        return brandNames;
    }

    public void setBrandNames(List<String> brandNames) {
        this.brandNames = brandNames;
    }

    public List<String> getProductCategoryNames() {
        return productCategoryNames;
    }

    public void setProductCategoryNames(List<String> productCategoryNames) {
        this.productCategoryNames = productCategoryNames;
    }

    public List<ProductAttr> getProductAttrs() {
        return productAttrs;
    }

    public void setProductAttrs(List<ProductAttr> productAttrs) {
        this.productAttrs = productAttrs;
    }


    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class ProductAttr {
        private Long attrId;
        private String attrName;
        private List<String> attrValues;

        public ProductAttr() {
        }

        public Long getAttrId() {
            return attrId;
        }

        public void setAttrId(Long attrId) {
            this.attrId = attrId;
        }

        public String getAttrName() {
            return attrName;
        }

        public void setAttrName(String attrName) {
            this.attrName = attrName;
        }

        public List<String> getAttrValues() {
            return attrValues;
        }

        public void setAttrValues(List<String> attrValues) {
            this.attrValues = attrValues;
        }
    }
}


