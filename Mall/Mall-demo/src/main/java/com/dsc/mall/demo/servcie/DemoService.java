package com.dsc.mall.demo.servcie;

import com.dsc.mall.demo.dto.PmsBrandDto;
import com.dsc.mall.model.PmsBrand;

import java.util.List;

/**
 * @author 60221
 *Service 接口
 */
public interface DemoService {
    /**
     * 查询所有
     * @return
     */
    List<PmsBrand> listAllBrand();

    /**
     *  创建新品牌
     * @param pmsBrandDto
     * @return
     */
    int createBrand(PmsBrandDto pmsBrandDto);

    /**
     * 更新
     * @param id
     * @param pmsBrandDto
     * @return
     */
    int updateBrand(Long id, PmsBrandDto pmsBrandDto);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteBrand(Long id);

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 获取单个
     * @param id
     * @return
     */
    PmsBrand getBrand(Long id);
}
