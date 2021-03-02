package com.dsc.mall.dao;

import com.dsc.mall.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品和专题关系操作Dao
 * @Author:estic
 * @Date: 2021/3/2 21:37
 */
public interface CmSaubjectProductRelationDao {

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
