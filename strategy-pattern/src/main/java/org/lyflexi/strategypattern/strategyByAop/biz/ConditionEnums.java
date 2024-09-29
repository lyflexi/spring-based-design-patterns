package org.lyflexi.strategypattern.strategyByAop.biz;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/14 21:05
 */

public enum ConditionEnums {
    ACTION_ONE("ACTION_ONE","paramAHandler"),
    ACTION_TWO("ACTION_TWO","paramBHandler");

    /*方法参数枚举值*/
    private String type ;
    /*beanName*/
    private String value ;

    ConditionEnums(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public static ConditionEnums match(String type) {
        for (ConditionEnums conditionEnum : values()) {
            if (conditionEnum.type.equals(type)) {
                return conditionEnum;
            }
        }
        throw new RuntimeException("枚举不存在");
    }
}
