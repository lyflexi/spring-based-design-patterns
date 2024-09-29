package org.lyflexi.strategypattern.strategyByInitializingBean;


import org.lyflexi.strategypattern.strategyByInitializingBean.enums.StrategyInitializeType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:28
 */
public class StrategyFactory {

    private static Map<String, AbstractStrategy> strategies = new ConcurrentHashMap<>();

    public static synchronized void registerStrategy(AbstractStrategy strategy) {
        strategies.put(strategy.getName(), strategy);
    }

    public static AbstractStrategy getStrategy(StrategyInitializeType strategyInitializeType) {
        return strategies.get(strategyInitializeType.getIdentifier());
    }
}