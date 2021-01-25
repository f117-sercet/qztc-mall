package com.dsc.portal.repository;

import com.dsc.portal.domain.MemberProductCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 60221
 * 商品收藏Repository
 */
public interface MemberProductCollectionRepository extends MongoRepository<MemberProductCollection,String> {

    /**
     * 寻找
     * @param memberId
     * @param productId
     * @return
     */
    MemberProductCollection findByMemberIdAndProductId(Long memberId, Long productId);

    /**
     * 删除
     * @param memberId
     * @param productId
     * @return
     */
    int deleteByMemberIdAndProductId(Long memberId,Long productId);

    /**
     * 通过Id寻找
     * @param memberId
     * @param pageable
     * @return
     */
    Page<MemberProductCollection> findByMemberId(Long memberId, Pageable pageable);

    /**
     * 删除所有
     * @param memberId
     * @return
     */
    int deleteAllByMemberId(Long memberId);
}
