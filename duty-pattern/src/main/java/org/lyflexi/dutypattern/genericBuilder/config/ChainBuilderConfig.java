package org.lyflexi.dutypattern.genericBuilder.config;


import org.lyflexi.dutypattern.genericBuilder.ChainBuilder;
import org.lyflexi.dutypattern.genericBuilder.model.LoginUser;
import org.lyflexi.dutypattern.genericBuilder.model.Robot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/28 19:54
 */
@Configuration
public class ChainBuilderConfig {
    @Bean
    public ChainBuilder<LoginUser, Boolean> loginUserChainBuilder() {
        return new ChainBuilder<LoginUser, Boolean>();
    }
    @Bean
    public ChainBuilder<Robot, Boolean> robotChainBuilder() {
        return new ChainBuilder<Robot, Boolean>();
    }

}
