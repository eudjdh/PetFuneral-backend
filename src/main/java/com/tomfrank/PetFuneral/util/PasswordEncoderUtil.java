package com.tomfrank.PetFuneral.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码编码工具，基于 BCrypt
 */
public class PasswordEncoderUtil {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    /**
     * 哈希原始密码
     */
    public static String hash(String raw) {
        return ENCODER.encode(raw);
    }

    /**
     * 校验原始密码与已编码密码是否匹配
     */
    public static boolean matches(String raw, String encoded) {
        return ENCODER.matches(raw, encoded);
    }
}