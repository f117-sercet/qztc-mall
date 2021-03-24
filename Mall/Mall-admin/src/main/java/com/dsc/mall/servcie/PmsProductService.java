package com.dsc.mall.servcie;

import com.dsc.mall.dto.PmsProductParam;
import com.dsc.mall.dto.PmsProductQueryParam;
import com.dsc.mall.dto.PmsProductResult;
import com.dsc.mall.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品管理Service
 * @Author:estic
 * @Date: 2021/3/24 19:59
 */
public interface PmsProductService {
    /**
     * 创建商品
     * @param productParam
     * @return
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int create(PmsProductParam productParam);

    /**
     * 根据商品编号获取更新信息
     * @param id
     * @return
     */
    PmsProductResult getUpdateInfo(Long id);

    /**
     * 更新商品
     * @param id
     * @param productParam
     * @return
     */
    @Transactional
    int update(Long id, PmsProductParam productParam);

    /**
     * 分页查询
     * @param productQueryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量修改审核状态
     * @param ids
     * @param verifyStatus
     * @param detail
     * @return
     */
    @Transactional
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 批量修改商品上架状态
     * @param ids
     * @param publishStatus
     * @return
     */

    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改新品状态
     * @param ids
     * @param newStatus
     * @return
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量删除商品
     * @param ids
     * @param deleteStatus
     * @return
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 根据商品名称或者货号模糊查询
     * @param keyword
     * @return
     */
    List<PmsProduct> list(String keyword);
}
