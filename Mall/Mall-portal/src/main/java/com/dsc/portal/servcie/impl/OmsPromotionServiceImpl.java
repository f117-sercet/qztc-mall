package com.dsc.portal.servcie.impl;

import com.dsc.mall.model.OmsCartItem;
import com.dsc.mall.model.PmsSkuStock;
import com.dsc.portal.dao.PortalProductDao;
import com.dsc.portal.domain.CartPromotionItem;
import com.dsc.portal.domain.PromotionProduct;
import com.dsc.portal.servcie.OmsPromotionService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 促销管理Service实现类
 * @author 60221
 */
@Service
public class OmsPromotionServiceImpl implements OmsPromotionService {
    @Autowired
    private PortalProductDao portalProductDao;
    @Override
    public List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList) {
        //1.先根据productId对CartItem进行分组，以spu为单位进行计算优惠
        Map<Long,List<OmsCartItem>> productCartMap = groupCartItemBySpu(cartItemList);
        //2.查询所有商品的优惠相关信息
        List<PromotionProduct> promotionProductList = getPromotionProductList(cartItemList);
        //3.根据商品促销类型计算商品促销优惠价格
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        for (Map.Entry<Long,List<OmsCartItem>>entry:productCartMap.entrySet()){
            Long productId = entry.getKey();
            PromotionProduct promotionProduct = getPromotionProductById(productId,promotionProductList);
            List<OmsCartItem> itemList = entry.getValue();
            Integer promotionType = promotionProduct.getPromotionType();
            if (promotionType == 1){
                //单品促销
                for(OmsCartItem item :itemList){
                    CartPromotionItem cartPromotionItem = new CartPromotionItem();
                    BeanUtils.copyProperties(item,cartPromotionItem);
                    cartPromotionItem.setPromotionMessage("单品促销");
                    //商品原价-促销价
                    PmsSkuStock skuStock = getOriginalPrice(promotionProduct,item.getProductSkuId());

                }
            }

        }

        return null;
    }

    /**
     * 获取商品的原价
     * @param promotionProduct
     * @param productSkuId
     * @return
     */
    private PmsSkuStock getOriginalPrice(PromotionProduct promotionProduct, Long productSkuId) {

        for (PmsSkuStock skuStock:promotionProduct.getSkuStockList()){
            if (productSkuId.equals(skuStock.getId())){
                return skuStock;
            }
        }
        return null;
    }

    /**
     * 根据商品Id获取商品的促销信息
     * @param productId
     * @param promotionProductList
     * @return
     */
    private PromotionProduct getPromotionProductById(Long productId, List<PromotionProduct> promotionProductList) {

        for (PromotionProduct promotionProduct:promotionProductList){
            if (productId.equals(promotionProduct.getId())){
                return promotionProduct;
            }
        }
        return null;
    }

    /**
     * 查询所有商品的优惠相关信息
     * @param cartItemList
     * @return
     */
    private List<PromotionProduct> getPromotionProductList(List<OmsCartItem> cartItemList) {

        List<Long> productIdList = new ArrayList<>();
        for (OmsCartItem cartItem:cartItemList){
            productIdList.add(cartItem.getProductId());
        }
        return portalProductDao.getPromotionProductList(productIdList);
    }

    /**
     * 以spu为单位对购物车中的商品进行分组
     * @param cartItemList
     * @return
     */
    private Map<Long, List<OmsCartItem>> groupCartItemBySpu(List<OmsCartItem> cartItemList) {

        Map<Long,List<OmsCartItem>> productCartMap = new TreeMap<>();
        for (OmsCartItem cartItem:cartItemList){
            List<OmsCartItem> productCartItemList = productCartMap.get(cartItem.getProductId());
         if (productCartItemList == null){
             productCartItemList = new ArrayList<>();
             productCartItemList.add(cartItem);
             productCartMap.put(cartItem.getProductId(),productCartItemList);
         }else {
             productCartItemList.add(cartItem);
         }
        }
        return productCartMap;
    }
}
