package com.bean.mall.portal.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class HomeFlashPromotion {
    private Date startTime;
    private Date endTime;
    private Date nextStartTime;
    private Date nextEndTime;
    //属于该秒杀活动的商品
    private List<FlashPromotionProduct> productList;


    public HomeFlashPromotion(Date startTime, Date endTime, Date nextStartTime, Date nextEndTime, List<FlashPromotionProduct> productList) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.nextStartTime = nextStartTime;
        this.nextEndTime = nextEndTime;
        this.productList = productList;
    }

    public HomeFlashPromotion() {
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getNextStartTime() {
        return nextStartTime;
    }

    public void setNextStartTime(Date nextStartTime) {
        this.nextStartTime = nextStartTime;
    }

    public Date getNextEndTime() {
        return nextEndTime;
    }

    public void setNextEndTime(Date nextEndTime) {
        this.nextEndTime = nextEndTime;
    }

    public List<FlashPromotionProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<FlashPromotionProduct> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "HomeFlashPromotion{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", nextStartTime=" + nextStartTime +
                ", nextEndTime=" + nextEndTime +
                ", productList=" + productList +
                '}';
    }
}


