package com.dsc.portal.servcie;

import com.dsc.portal.domain.MemberBrandAttention;
import org.springframework.data.domain.Page;

/**
 * @author 60221
 * 会员关注管理Service
 */
public interface MemberAttentionService {
    /**
     * 添加关注
     * @param memberBrandAttention
     * @return
     */
    int add(MemberBrandAttention memberBrandAttention);

    /**
     * 取消关注
     * @param brandId
     * @return
     */
    int delete(Long brandId);

    /**
     * 获取用户关注
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<MemberBrandAttention> lsit(Integer pageNum, Integer pageSize);

    /**
     * 获取用户关注详情
     * @param brandId
     * @return
     */
    MemberBrandAttention detail(Long brandId);

    /**
     * 清空列表
     */
    void  clear();
}
