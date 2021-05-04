package com.dsc.mall.portal.domain;

import com.dsc.mall.model.PmsProduct;
import com.dsc.mall.model.PmsProductFullReduction;
import com.dsc.mall.model.PmsProductLadder;
import com.dsc.mall.model.PmsSkuStock;

import java.util.List;

/**
 * @author 60221
 * 商品的信息，包括sku，打折优惠，满减优惠
 */
public class PromotionProduct extends PmsProduct
{
    /**商品库存信息
     *
     */
    private List<PmsSkuStock> skuStockList;
    /**商品打折信息
     *
     */
    private List<PmsProductLadder> productLadderList;
    /**商品满减信息
     *
     */
    private List<PmsProductFullReduction> productFullReductionList;

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
}
