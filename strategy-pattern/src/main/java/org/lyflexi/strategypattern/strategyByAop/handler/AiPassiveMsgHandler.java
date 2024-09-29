package org.lyflexi.strategypattern.strategyByAop.handler;

import java.io.IOException;
import java.util.Map;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:49
 */
public abstract class AiPassiveMsgHandler {
    public abstract Map<String, Object> handle(Map<String, Object> params) throws IOException;
}
