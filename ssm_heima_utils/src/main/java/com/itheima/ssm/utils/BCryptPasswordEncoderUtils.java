package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * 对密码进行加密
     * @param password
     * @return
     */
    public static String encodePassWord(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
