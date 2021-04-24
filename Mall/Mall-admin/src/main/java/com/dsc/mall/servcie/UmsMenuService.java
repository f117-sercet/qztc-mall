package com.dsc.mall.servcie;

import com.dsc.mall.dto.UmsMenuNode;
import com.dsc.mall.model.UmsMenu;

import java.util.List;

/**
 * 后台菜单管理Service
 * @Author:estic
 * @Date: 2021/4/6 23:21
 */
public interface UmsMenuService {
    /**
     * 创建后台菜单
     * @param umsMenu
     * @return
     */
    int create(UmsMenu umsMenu);

    /**
     *  修改后台菜单
     * @param id
     * @param umsMenu
     * @return
     */
    int update(Long id,UmsMenu umsMenu);

    /**
     * 获取项目
     * @param id
     * @return
     */
    UmsMenu getItem(Long id);

    /**
     * 根据ID删除名单
      * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 分页查询后台菜单
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树型结构返回所有菜单列表
     * @return
     */
    List<UmsMenuNode> treeList();

    /**
     * 修改菜单显示状态
     * @param id
     * @param hidden
     * @return
     */
    int updateHidden(Long id,Integer hidden);

}
