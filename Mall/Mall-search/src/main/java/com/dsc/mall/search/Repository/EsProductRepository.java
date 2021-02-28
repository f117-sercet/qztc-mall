package com.dsc.mall.search.Repository;

import com.dsc.mall.search.domain.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 搜索商品ES操作类
 * @Author:estic
 * @Date: 2021/2/28 16:11
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {
    /**
     * 搜索查询
     * @param name
     * @param subTitle
     * @param keywords
     * @param page
     * @return
     */
   Page findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}
