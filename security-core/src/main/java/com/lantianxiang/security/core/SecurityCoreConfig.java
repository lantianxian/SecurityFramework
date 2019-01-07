package com.lantianxiang.security.core;

import com.lantianxiang.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Create by Lantianxiang
 * Description: 使SecurityProperties.class配置类生效
 * Create Date: 2018/12/27
 * Create Time: 15:44
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {


}
