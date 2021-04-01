package com.dsc.mall.servcie;

import com.dsc.mall.model.UmsAdmin;
import com.dsc.mall.model.UmsResource;

import java.util.List;

/**
 * 后台用户缓存操作Servcie
 * @Author:estic
 * @Date: 2021/4/1 21:43
 */
public interface UmsAdminCacheService {
    /**
     * 删除后台用户缓存
     * @param adminId
     */
    void delAdmin(Long adminId);

    /**
     *
     * 删除后台用户资源列表缓存
     * @param adminId
     */
    void delResourceList(Long adminId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     * @param roleId
     */
    void delResourceListByRole(Long roleId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     * @param roleIds
     */
    void delResourceListByRoleIds(List<Long> roleIds);

    /**
     * 当资源信息改变时，删除资源项目后台用户缓存
     * @param resourceId
     */
    void delResourceListByResource(Long resourceId);

    /**
     * 获取缓存后台用户信息
     * @param username
     * @return
     */
    UmsAdmin getAdmin(String username);

    /**
     * 设置缓存后台用户信息
     * @param admin
     */
    void setAdmin(UmsAdmin admin);

    /**
     * 获取缓存后台用户资源列表
     * @return
     * @param adminId
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 设置后台后台用户资源列表
     * @param adminId
     * @param resourceList
     */
    void setResourceList(Long adminId, List<UmsResource> resourceList);
}
