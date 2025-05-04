package com.tomfrank.PetFuneral.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import com.tomfrank.PetFuneral.config.JwtProperties;

/**
 * JWT 工具类，基于 JJWT
 */
@Component
public class JwtUtil {
    private final JwtProperties props;
    private Key key;

    public JwtUtil(JwtProperties props) {
        this.props = props;
    }

    @PostConstruct
    public void init() {
        // 使用配置文件中的 secret 生成密钥
        this.key = Keys.hmacShaKeyFor(props.getSecret().getBytes());
    }

    /**
     * 生成 token
     * @param userId 用户 ID
     * @param username 用户名
     * @return JWT token
     */
    public String generateToken(Integer userId, String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + props.getExpirationMillis());

        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("username", username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 解析并验证 JWT
     * @param token JWT 字符串
     * @return Claims 对象
     */
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}