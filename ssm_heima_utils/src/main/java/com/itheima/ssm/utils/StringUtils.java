package com.itheima.ssm.utils;

public class StringUtils {
    private StringUtils() {
    }

    /**
     * 判断字符串是否为空
     * @param value
     * @return
     */
    public static boolean hasLength(String value) {
        return value != null && !"".equals(value.trim());
    }

}
