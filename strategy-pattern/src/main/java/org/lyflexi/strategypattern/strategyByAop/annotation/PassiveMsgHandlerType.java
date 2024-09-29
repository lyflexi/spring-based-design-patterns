package org.lyflexi.strategypattern.strategyByAop.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:43
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PassiveMsgHandlerType {
    String value() ;
}