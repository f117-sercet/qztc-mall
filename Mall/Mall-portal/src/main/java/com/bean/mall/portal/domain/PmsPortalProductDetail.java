package com.bean.mall.portal.domain;

import com.bean.model.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 前台商品详情
 */

public class PmsPortalProductDetail {
    @ApiModelProperty("商品信息")
    private PmsProduct product;
    @ApiModelProperty("商品品牌")
    private PmsBrand brand;
    @ApiModelProperty("商品属性与参数")
    private List<PmsProductAttribute> productAttributeList;
    @ApiModelProperty("手动录入的商品属性与参数值")
    private List<PmsProductAttributeValue> productAttributeValueList;
    @ApiModelProperty("商品的sku库存信息")
    private List<PmsSkuStock> skuStockList;
    @ApiModelProperty("商品阶梯价格设置")
    private List<PmsProductLadder> productLadderList;
    @ApiModelProperty("商品满减价格设置")
    private List<PmsProductFullReduction> productFullReductionList;
    @ApiModelProperty("商品可用优惠券")
    private List<SmsCoupon> couponList;

    public PmsPortalProductDetail() {
    }

    public PmsPortalProductDetail(PmsProduct product, PmsBrand brand, List<PmsProductAttribute> productAttributeList, List<PmsProductAttributeValue> productAttributeValueList, List<PmsSkuStock> skuStockList, List<PmsProductLadder> productLadderList, List<PmsProductFullReduction> productFullReductionList, List<SmsCoupon> couponList) {
        this.product = product;
        this.brand = brand;
        this.productAttributeList = productAttributeList;
        this.productAttributeValueList = productAttributeValueList;
        this.skuStockList = skuStockList;
        this.productLadderList = productLadderList;
        this.productFullReductionList = productFullReductionList;
        this.couponList = couponList;
    }

    public PmsProduct getProduct() {
        return product;
    }

    public void setProduct(PmsProduct product) {
        this.product = product;
    }

    public PmsBrand getBrand() {
        return brand;
    }

    public void setBrand(PmsBrand brand) {
        this.brand = brand;
    }

    public List<PmsProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<PmsProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }

    public List<PmsProductAttributeValue> getProductAttributeValueList() {
        return productAttributeValueList;
    }

    public void setProductAttributeValueList(List<PmsProductAttributeValue> productAttributeValueList) {
        this.productAttributeValueList = productAttributeValueList;
    }

    public List<PmsSkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<PmsSkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<PmsProductLadder> getProductLadderList() {
        return productLadderList;
    }

    public void setProductLadderList(List<PmsProductLadder> productLadderList) {
        this.productLadderList = productLadderList;
    }

    public List<PmsProductFullReduction> getProductFullReductionList() {
        return productFullReductionList;
    }

    public void setProductFullReductionList(List<PmsProductFullReduction> productFullReductionList) {
        this.productFullReductionList = productFullReductionList;
    }

    public List<SmsCoupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<SmsCoupon> couponList) {
        this.couponList = couponList;
    }
}
