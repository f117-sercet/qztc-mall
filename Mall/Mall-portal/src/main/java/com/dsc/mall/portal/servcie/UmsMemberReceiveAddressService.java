package com.dsc.mall.portal.servcie;


import com.dsc.mall.model.UmsMemberReceiveAddress;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户地址管理Service
 * @author 60221
 */
public interface UmsMemberReceiveAddressService {
    /**
     * 添加收货地址
     * @return
     * @param address
     */
    int add(UmsMemberReceiveAddress address);

    /**
     * 删除收货地址
     * @param id 地址表的id
     * @return
     */
    int delete(Long id);

    /**
     * 修改收货地址
     * @param id 地址表的id
     * @param address 修改的收货地址信息
     * @return
     * @rollback
     */
    @Transactional
    int update(Long id, UmsMemberReceiveAddress address);

    /**
     * 返回当前用户收货地址
     * @return
     */
    List<UmsMemberReceiveAddress> list();

    /**
     * 获取地址详情
     * @param id 地址id
     * @return
     */
    UmsMemberReceiveAddress getItem(Long id);
}
