package com.erlang.demo;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Field;

/**
 * @author yj
 * @since 2021-02-18 14:21
 */
public class AopReflectUtils {

    public static Object getCglibProxyTargetObject(Object source) throws Exception {
        Class<?> clazz = source.getClass();

        Field field = clazz.getDeclaredField("CGLIB$CALLBACK_0");
        field.setAccessible(true);

        Object advisedInterceptor = field.get(source);
        Field advised = advisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        return ((AdvisedSupport) advised.get(advisedInterceptor)).getTargetSource().getTarget();
    }

    public static void setCglibDynamicTargetObjectField(Object source, Object value, String fieldName) throws Exception {
        Class<?> clazz = AopUtils.getTargetClass(source);
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);

        Object target = getCglibProxyTargetObject(source);
        field.set(target, value);
    }

    public static void setJDKDynamicObjectField(Object source, Object value, String fieldName) throws Exception {
        Class<?> clazz = AopUtils.getTargetClass(source);
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        Object target = getJDKProxyTargetObject(source);
        field.set(target, value);
    }

    public static Object getJDKProxyTargetObject(Object source) throws Exception {
        Class<?> clazz = source.getClass().getSuperclass();

        Field field = clazz.getDeclaredField("h");
        field.setAccessible(true);

        Object advisedInterceptor = field.get(source);
        Field advised = advisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        return ((AdvisedSupport) advised.get(advisedInterceptor)).getTargetSource().getTarget();
    }

    public static void setObjectField(Object source, Object value, String fieldName) throws Exception {
        Class<?> clazz = AopUtils.getTargetClass(source);
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(source, value);
    }

    public static void setObjectTargetField(Object source, Object value, String fieldName) throws Exception {
        if (AopUtils.isCglibProxy(source)) {
            setCglibDynamicTargetObjectField(source, value, fieldName);
        } else if (AopUtils.isJdkDynamicProxy(source)) {
            setJDKDynamicObjectField(source, value, fieldName);
        } else if (!AopUtils.isAopProxy(source)) {
            setObjectField(source, value, fieldName);
        }
    }
}
