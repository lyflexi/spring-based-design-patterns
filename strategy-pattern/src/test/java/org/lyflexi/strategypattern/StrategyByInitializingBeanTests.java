package org.lyflexi.strategypattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.lyflexi.strategypattern.strategyByInitializingBean.AbstractStrategy;
import org.lyflexi.strategypattern.strategyByInitializingBean.StrategyFactory;
import org.lyflexi.strategypattern.strategyByInitializingBean.enums.StrategyInitializeType;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 策略模式：基于InitializingBean 与手写策略工厂
 */
@SpringBootTest
@Slf4j
class StrategyByInitializingBeanTests {



    @Test
    void contextLoads() {
        StrategyInitializeType typeA = StrategyInitializeType.fromIdentifier("TYPE_A");
        StrategyInitializeType typeB = StrategyInitializeType.fromIdentifier("TYPE_B");

        AbstractStrategy strategyA = StrategyFactory.getStrategy(typeA);
        strategyA.execute("dataA");
        AbstractStrategy strategyB = StrategyFactory.getStrategy(typeB);
        strategyB.execute("dataB");
    }

}
