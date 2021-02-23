package com.erlang.demo.unit_test.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期格式化工具类
 *
 * @author yj
 * @since 2021-02-07 9:49
 */
public class DateUtil {

    public static String formatOfPattern(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }
}
