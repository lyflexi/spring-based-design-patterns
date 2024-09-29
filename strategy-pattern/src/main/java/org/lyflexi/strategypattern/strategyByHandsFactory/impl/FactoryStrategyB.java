package org.lyflexi.strategypattern.strategyByHandsFactory.impl;

import jakarta.annotation.PostConstruct;

import org.lyflexi.strategypattern.strategyByHandsFactory.AbstractFactoryStrategy;
import org.lyflexi.strategypattern.strategyByHandsFactory.enums.StrategyFactoryType;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:14
 */
@Component
public class FactoryStrategyB extends AbstractFactoryStrategy {
    @Override
    public void execute(String data) {
        System.out.println("Executing Strategy B with data: " + data);
    }

    @PostConstruct
    public void init() {
        super.setName(StrategyFactoryType.TYPE_B.getIdentifier());
    }
}