package com.dsc.mall.servcie;

import com.dsc.mall.model.SmsHomeAdvertise;

import java.util.List;

/**
 * 首页广告管理Service
 * @Author:estic
 * @Date: 2021/3/26 10:00
 */
public interface SmsHomeAdvertiseService {
    /**
     * 添加广告
     * @param advertise
     * @return
     */
    int create(SmsHomeAdvertise advertise);

    /**
     * 批量删除广告
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 修改上，下限状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Long id,Integer status);

    /**
     * 获取广告详情
     * @param id
     * @return
     */
    SmsHomeAdvertise getItem(Long id);

    /**
     * 更新广告
     * @param id
     * @param advertise
     * @return
     */
    int update(Long id, SmsHomeAdvertise advertise);

    /**
     * 分页查询广告
     * @param name
     * @param type
     * @param endTime
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);
}
