package com.dsc.mall.portal.servcie;


import com.dsc.mall.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理Service
 * @author 60221
 */
public interface UmsMemberService {
    /**
     * 根据用户名获取会员
     * @return
     * @param username
     */
    UmsMember getByUsername(String username);

    /**
     * 根据会员编号获取会员
     * @return
     * @param id
     */
    UmsMember getById(Long id);

    /**
     * 用户注册
     * @param username
     * @param authCode
     * @param password
     * @param telephone
     *
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);

    /**
     * 生成验证码
     * @param
     * @return
     * @param telephone
     */
    String generateAuthCode(String telephone);

    /**
     * 修改密码
     * @param telephone
     * @param password
     * @param authCode
     */
    @Transactional
    void updatePassword(String telephone, String password, String authCode);

    /**
     * 获取当前登录会员
     * @return
     *
     */
    UmsMember getCurrentMember();

    /**
     * 根据会员id修改会员积分
     * @param id
     *
     */
    void updateIntegration(Long id,Integer integration);


    /**
     * 获取用户信息
     * @return
     * @param username
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 登录后获取token
     * @param password
     * @param username
     * @return
     */
    String login(String username, String password);

    /**
     * 刷新token
     * @return
     * @param token
     */
    String refreshToken(String token);
}
