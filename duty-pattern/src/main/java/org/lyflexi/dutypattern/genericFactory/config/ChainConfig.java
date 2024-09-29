package org.lyflexi.dutypattern.genericFactory.config;



import org.lyflexi.dutypattern.genericFactory.AbstractHandler;
import org.lyflexi.dutypattern.genericFactory.ChainFactory;
import org.lyflexi.dutypattern.genericFactory.model.LoginUser;
import org.lyflexi.dutypattern.genericFactory.model.Robot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/28 19:54
 */
@Configuration
public class ChainConfig {
    @Bean
    public ChainFactory loginUserChainFactory(List<AbstractHandler<LoginUser,Boolean>> handlers) {
        return new ChainFactory(handlers);
    }
    @Bean
    public ChainFactory robotChainFactory(List<AbstractHandler<Robot,Boolean>> handlers) {
        return new ChainFactory(handlers);
    }

}
