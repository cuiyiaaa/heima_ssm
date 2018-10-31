package com.itheima.ssm.utils;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.*;
import java.util.Date;

public class DateFormatUtils {

    private DateFormatUtils() {
    }

    /**
     * 将日期转换为指定的日期格式的字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        String format = df.format(date);
        return format;
    }

    /**
     * 将字符串根据指定的格式转换为时间
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date stringToDate(String date, String pattern) {
        try {
            DateFormat df = new SimpleDateFormat(pattern);
            return df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("时间转换异常~~~");
        }
    }

}
