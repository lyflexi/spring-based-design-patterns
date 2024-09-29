package org.lyflexi.strategypattern.strategyByAop.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 23:05
 */
public class JoinPointUtils {
    /**
     * 获取注解全信息
     *
     * @param joinPoint
     * @return
     */
    public static <T extends Annotation> T getAnnotationByClass(JoinPoint joinPoint, Class<T> annotationClass) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 获取注解参数
        return method.getAnnotation(annotationClass);
    }

    /**
     * 获取方法参数全信息，必须同时根据paramName和clazz才能确定唯一
     * @param joinPoint
     * @param paramName 方法参数名
     * @param clazz 方法参数类型
     * @param <T>
     * @return
     */
    public static <T> T getCertainParam(JoinPoint joinPoint, String paramName, Class<T> clazz) {
        // 获取所有参数的值
        Object[] args = joinPoint.getArgs();
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();;
        // 在方法签名中获取所有参数的名称
        String[] parameterNames = methodSignature.getParameterNames();
        // 根据参数名称拿到下标， 参数值的数组和参数名称的数组下标是一一对应的
        int index = ArrayUtils.indexOf(parameterNames, paramName);
        // 在参数数组中取出下标对应参数值
        Object obj = args[index];

        if (obj == null) {
            return null;
        }
        return clazz.cast(obj);
    }

}
