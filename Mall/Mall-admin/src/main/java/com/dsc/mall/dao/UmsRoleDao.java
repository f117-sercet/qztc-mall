package com.dsc.mall.dao;

import com.dsc.mall.model.UmsMenu;
import com.dsc.mall.model.UmsResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义后台角色管理Dao
 * @Author:estic
 * @Date: 2021/3/7 11:31
 */
public interface UmsRoleDao {

    /**
     * 根据后台用户ID获取菜单
     * @param adminId
     * @return
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);

    /**
     * 根据角色ID获取菜单
     * @param roleId
     * @return
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);

    /**
     * 根据角色ID获取资源
     * @param roleId
     * @return
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
