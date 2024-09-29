package org.lyflexi.strategypattern.strategyByInitializingBean.impl;


import org.lyflexi.strategypattern.strategyByInitializingBean.AbstractStrategy;
import org.lyflexi.strategypattern.strategyByInitializingBean.enums.StrategyInitializeType;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:14
 */
@Component
public class StrategyB extends AbstractStrategy {
    @Override
    public void execute(String data) {
        System.out.println("Executing Strategy B with data: " + data);
    }
    @Override
    public void setName(String name) {
        super.setName(StrategyInitializeType.TYPE_B.getIdentifier());
    }
}