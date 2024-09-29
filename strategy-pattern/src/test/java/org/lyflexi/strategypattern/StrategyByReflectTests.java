package org.lyflexi.strategypattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.lyflexi.strategypattern.strategyByReflect.StrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 策略模式：基于枚举和按需反射机制
 */
@SpringBootTest
@Slf4j
class StrategyByReflectTests {
    @Autowired
    private StrategyContext context;


    @Test
    void contextLoads() {
        context.setStrategy("TYPE_A");
        context.executeStrategy("data");
        log.info("Strategy: {}  executed",context.getStrategyName());
        return ;
    }

}
