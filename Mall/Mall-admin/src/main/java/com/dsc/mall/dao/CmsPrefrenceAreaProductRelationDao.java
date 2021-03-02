package com.dsc.mall.dao;

import com.dsc.mall.model.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义优选和商品相关操作Dao
 * @Author:estic
 * @Date: 2021/3/2 21:31
 */
public interface CmsPrefrenceAreaProductRelationDao {
    /**
     * 批量创建
     * @param prefrenceAreaProductRelationList
     * @return
     */
    int insertList(@Param("List")List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}
