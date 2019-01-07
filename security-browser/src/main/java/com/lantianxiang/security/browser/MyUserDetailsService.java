package com.lantianxiang.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Create by Lantianxiang
 * Description: 自定义用户认证逻辑
 * Create Date: 2018/12/26
 * Create Time: 16:46
 **/
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    /**
     * 根据username查询用户实体
     * @param username 用户名
     * @return 用户实体
     * @throws UsernameNotFoundException the username is not found from database
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("login user is：{}", username);
        //TODO 实际开发中从数据库中读取
        //根据用户名查找用户信息
        //根据查找到的用户信息判断用户是否已被冻结
        //用户密码加密解密
        String password = passwordEncoder.encode("123456");
        logger.info("the encrypted password is : {}", password);
        return new User(username, password,
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
