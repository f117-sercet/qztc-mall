package com.dsc.mall.dao;

import com.dsc.mall.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品和专题相关操作Dao
 * @Author:estic
 * @Date: 2021/4/20 17:24
 */
public interface CmsSubjectProductRelationDao {
    /**
     *批量创建
     * @param subjectProductRelationList
     * @return
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
