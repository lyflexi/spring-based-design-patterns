package org.lyflexi.strategypattern.strategyByInitializingBean;

import org.springframework.beans.factory.InitializingBean;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:26
 */
public abstract class AbstractStrategy implements Strategy, InitializingBean {

    private String name;

    protected String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() {
        setName(name);
        StrategyFactory.registerStrategy(this);
    }


}
