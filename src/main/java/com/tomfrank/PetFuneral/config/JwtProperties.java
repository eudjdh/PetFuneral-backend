package com.tomfrank.PetFuneral.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * JWT 配置属性
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    /** 用于签名的密钥，至少 256 位随机字符串 */
    private String secret;
    /** 过期时间，单位毫秒 */
    private long expirationMillis = 86400000;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpirationMillis() {
        return expirationMillis;
    }

    public void setExpirationMillis(long expirationMillis) {
        this.expirationMillis = expirationMillis;
    }
}