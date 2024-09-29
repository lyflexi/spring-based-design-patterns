package org.lyflexi.strategypattern.strategyByReflect;

import org.lyflexi.strategypattern.strategyByReflect.enums.StrategyTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:16
 */
@Component
public class StrategyContext {

    private Strategy strategy;
    private String strategyName;

    public void setStrategy(String strategyType) {
        StrategyTypeEnum type = StrategyTypeEnum.valueOf(strategyType.toUpperCase());
        this.strategy = type.getInstance();
        this.strategyName = type.getName();
    }

    public void executeStrategy(String data) {
        strategy.execute(data);
    }

    public String getStrategyName() {
        return strategyName;
    }
}