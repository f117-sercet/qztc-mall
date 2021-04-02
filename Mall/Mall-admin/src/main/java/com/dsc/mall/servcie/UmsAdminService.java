package com.dsc.mall.servcie;

import com.dsc.mall.dto.UmsAdminParam;
import com.dsc.mall.dto.UpdateAdminPasswordParam;
import com.dsc.mall.model.UmsAdmin;
import com.dsc.mall.model.UmsResource;
import com.dsc.mall.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台用户管理Service
 * @Author:estic
 * @Date: 2021/4/2 10:07
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     * @return
     * @param username
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     * @return
     * @param umsAdminParam
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     * @return
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户id获取用户
     * @return
     * @param id
     */
    UmsAdmin getItem(Long id);

    /**
     * 根据用户名或昵称分页查询用户
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     * @param id
     * @param admin
     * @return
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 删除指定用户
     * @return
     * @param id
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     * @param adminId
     * @param roleIds
     * @return
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对于角色
     * @param adminId
     * @return
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 获取指定用户的可访问资源
     * @param adminId
     * @return
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 修改密码
     * @param updatePasswordParam
     * @return
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);
}
