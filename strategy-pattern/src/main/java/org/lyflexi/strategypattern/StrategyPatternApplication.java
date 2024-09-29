package org.lyflexi.strategypattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.lyflexi.strategypattern.strategyByReflect.*"),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.lyflexi.strategypattern.strategyByInitializingBean.*"),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.lyflexi.strategypattern.strategyByAop.*"),
//        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.lyflexi.strategypattern.strategyByHandsFactory.*"),
})
public class StrategyPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrategyPatternApplication.class, args);
    }

}
