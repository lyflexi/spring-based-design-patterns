package org.lyflexi.strategypattern.strategyByAop.handler.methodHandler;

import lombok.extern.slf4j.Slf4j;
import org.lyflexi.strategypattern.strategyByAop.handler.AiPassiveMsgHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/14 21:32
 */
@Component
@Slf4j
public class ParamBHandler extends AiPassiveMsgHandler {
    @Override
    public Map<String, Object> handle(Map<String, Object> params) throws IOException {
        log.info("ParamBHandler begin");
        return new HashMap<>();
    }
}
