package org.lyflexi.strategypattern.strategyByAop.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:43
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AiPassiveMsg {
    /** 场景类型,具体场景和环节使用对应的类型前缀,用点拼接.系统=sys,安全=security,审核=audit.xxx.xxxx; */
    String sceneType() default "";

    /** 替换参数json字符串 */
    String param() default "";

    /** 用户id ["1001","1002","1003"] */
    String[] users() default {};
}