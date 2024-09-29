package org.lyflexi.strategypattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.lyflexi.strategypattern.strategyByAop.biz.BizServiceImpl;
import org.lyflexi.strategypattern.strategyByAop.biz.ConditionEnums;
import org.lyflexi.strategypattern.strategyByAop.biz.ParamA;
import org.lyflexi.strategypattern.strategyByAop.biz.ParamB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 策略模式：基于BeanFactory与面向注解的Aop实现
 */
@SpringBootTest
@Slf4j
class StrategyByAop {
    @Autowired
    private BizServiceImpl bizService;


    @Test
    void contextLoads() {
        bizService.applyPublish(ParamA.builder().condition(ConditionEnums.ACTION_ONE.getType()).build()
                , ParamB.builder().condition(ConditionEnums.ACTION_TWO.getType()).build());
        bizService.approvePublish(ParamA.builder().condition(ConditionEnums.ACTION_ONE.getType()).build()
                , ParamB.builder().condition(ConditionEnums.ACTION_TWO.getType()).build());
        return ;
    }

}
