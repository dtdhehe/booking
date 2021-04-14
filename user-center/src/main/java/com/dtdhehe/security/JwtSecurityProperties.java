package com.dtdhehe.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/3/19 11:16
 * @description
 **/
@Configuration
@ConfigurationProperties(prefix = "my.jwt")
@Data
public class JwtSecurityProperties {

    private String header;

    private String tokenPrefix;

    private String secret;

    private Long expireTime = 5 * 60 * 60L;

}
