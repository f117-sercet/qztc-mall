package com.dsc.portal.servcie;

import com.dsc.portal.domain.MemberProductCollection;
import org.springframework.data.domain.Page;

/**
 * @author 60221
 * 会员商品收藏管理Service
 */
public interface MemberCollectionServcie {
    /**
     * 添加收藏
     * @param productCollection
     * @return
     */
    int add(MemberProductCollection productCollection);

    /**
     * 删除收藏
     * @param productId
     * @return
     */
    int delete(Long productId);

    /**
     * 分页查询收藏
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<MemberProductCollection> List(Integer pageNum,Integer pageSize);

    /**
     * 查看收藏详情
     * @param productId
     * @return
     */
    MemberProductCollection detail(Long productId);

    /**
     * 清空收藏
     */
    void clear();
}
