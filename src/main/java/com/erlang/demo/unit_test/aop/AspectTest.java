package com.erlang.demo.unit_test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yj
 * @since 2021-02-18 9:45
 */
@Aspect
@Component
public class AspectTest {

    @Pointcut("target(com.erlang.demo.unit_test.service.impl.StudentServiceImpl)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object aroundGeneral(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        Object result = point.proceed(args);
        return result;
    }
}
