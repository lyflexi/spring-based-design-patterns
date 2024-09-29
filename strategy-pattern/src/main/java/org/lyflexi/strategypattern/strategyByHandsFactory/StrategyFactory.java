package org.lyflexi.strategypattern.strategyByHandsFactory;

import org.lyflexi.strategypattern.strategyByHandsFactory.enums.StrategyFactoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:28
 */
@Service
public class StrategyFactory {

    private final Map<String, AbstractFactoryStrategy> strategieMap = new ConcurrentHashMap<>();

    @Autowired
    public synchronized void registerStrategy(List<AbstractFactoryStrategy> strategies) {
        strategies.forEach(strategy -> {
            strategieMap.put(strategy.getName(), strategy)
        ;});
    }

    public AbstractFactoryStrategy getStrategy(StrategyFactoryType strategyFactoryType) {
        return strategieMap.get(strategyFactoryType.getIdentifier());
    }
}