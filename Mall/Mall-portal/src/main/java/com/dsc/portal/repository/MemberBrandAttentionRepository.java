package com.dsc.portal.repository;

import com.dsc.portal.domain.MemberBrandAttention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 会员关注
 * @author 60221
 */
public interface MemberBrandAttentionRepository extends MongoRepository<MemberBrandAttention,String> {
    /**
     * 寻找商品
     * @param memberId
     * @param brandId
     * @return
     */
    MemberBrandAttention findByMemberIdAndBrandId(Long memberId, Long brandId);

    /**
     * 删除商品
     * @param memberId
     * @param brandId
     * @return
     */
    int deleteByMemberIdAndBrandId(Long memberId,Long brandId);

    /**
     * 通过会员Id寻找
     * @param memberId
     * @param pageable
     * @return
     */
    Page<MemberBrandAttention> findByMemberId(Long memberId, Pageable pageable);

    /**
     *删除所有
     * @param memberId
     */
    void deleteAllByMemberId(Long memberId);
}
