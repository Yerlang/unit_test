package com.erlang.demo.unit_test;

import com.alibaba.fastjson.JSON;
import com.erlang.demo.unit_test.utils.CalculateUtil;
import com.erlang.demo.unit_test.utils.DateUtil;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * 参数化测试
 *
 * @author yj
 * @since 2021-02-07 8:50
 */
public class TestParameterized {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -6, -7, -10})
    public void testPositive(int value) {
        System.out.println("testPositive value=" + value);
        Assert.assertEquals(-value, Math.abs(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -6, -7, -10})
    public void testNegative(int x) {
        System.out.println("testNegative x=" + x);
        Assert.assertEquals(-x, Math.abs(x));
    }

    /**
     * MethodSource value 默认是方法名称
     *
     * @param dateTime 时间
     * @param pattern  格式
     * @param expected 预期
     */
    @ParameterizedTest
    @MethodSource(value = {"testDateFormatter"})
    public void testDateFormatter(LocalDateTime dateTime, String pattern, String expected) {
        Assert.assertEquals(expected, DateUtil.formatOfPattern(dateTime, pattern));
    }

    static List<Arguments> testDateFormatter() {
        String YYYY_MM_DD_HH_MM_SS = "YYYY-MM-dd HH:mm:ss";
        String YYYY_MM_DD_HH_MM = "YYYY-MM-dd HH:mm";
        String YYYY_MM_DD_HH = "YYYY-MM-dd HH";
        String YYYY_MM_DD = "YYYY-MM-dd";
        String YYYY_MM = "YYYY-MM";
        String YYYY = "YYYY";
        LocalDateTime dateTime = LocalDateTime.now();
        return Arrays.asList( // arguments:
                Arguments.arguments(dateTime, YYYY_MM_DD_HH_MM_SS, dateTime.format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS))),
                Arguments.arguments(dateTime, YYYY_MM_DD_HH_MM, dateTime.format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM))),
                Arguments.arguments(dateTime, YYYY_MM_DD_HH, dateTime.format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH))),
                Arguments.arguments(dateTime, YYYY_MM_DD, dateTime.format(DateTimeFormatter.ofPattern(YYYY_MM_DD))),
                Arguments.arguments(dateTime, YYYY_MM, dateTime.format(DateTimeFormatter.ofPattern(YYYY_MM))),
                Arguments.arguments(dateTime, YYYY, dateTime.format(DateTimeFormatter.ofPattern(YYYY)))
        );
    }

    @ParameterizedTest
    @CsvSource({"'[1,2]',3", "'[2,3]',5", "'[40,1]',41"})
    public void testSumByCsvSource(String input, String expected) {
        System.out.println(input);
        List<Integer> src = JSON.parseArray(input, Integer.class);
        Assert.assertEquals(Integer.valueOf(expected), CalculateUtil.sum(src));
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/test-sum.csv"})
    public void testSumByCsvFile(String input, String expected) {
        System.out.println(input);
        List<Integer> src = JSON.parseArray(input, Integer.class);
        Assert.assertEquals(Integer.valueOf(expected), CalculateUtil.sum(src));
    }
}
