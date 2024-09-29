package org.lyflexi.strategypattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.lyflexi.strategypattern.strategyByHandsFactory.AbstractFactoryStrategy;
import org.lyflexi.strategypattern.strategyByHandsFactory.StrategyFactory;
import org.lyflexi.strategypattern.strategyByHandsFactory.enums.StrategyFactoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 策略模式：基于Spring3新特性，通过构造函数@Autowired批量注入Bean
 */
@SpringBootTest
@Slf4j
class StrategyByHandsFactoryTests {

    @Autowired
    StrategyFactory strategyFactory;

    @Test
    void contextLoads() {
        StrategyFactoryType typeA = StrategyFactoryType.fromIdentifier("TYPE_A");
        StrategyFactoryType typeB = StrategyFactoryType.fromIdentifier("TYPE_B");

        AbstractFactoryStrategy strategyA = strategyFactory.getStrategy(typeA);
        strategyA.execute("dataA");
        AbstractFactoryStrategy strategyB = strategyFactory.getStrategy(typeB);
        strategyB.execute("dataB");
    }

}
