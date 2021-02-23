package com.erlang.demo.unit_test.utils;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 计算工具类
 *
 * @author yj
 * @since 2021-02-07 10:03
 */
public class CalculateUtil {

    public static Integer sum(List<Integer> src) {
        if (CollectionUtils.isEmpty(src)) {
            return 0;
        }
        return src.stream()
                .filter(item -> item != null)
                .collect(Collectors.summingInt(Integer::valueOf));
    }
}
