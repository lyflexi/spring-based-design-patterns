package org.lyflexi.strategypattern.strategyByAop.biz;

import lombok.extern.slf4j.Slf4j;
import org.lyflexi.strategypattern.strategyByAop.annotation.AiPassiveMsg;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:47
 */
@Service
@Slf4j
public class BizServiceImpl {

    @AiPassiveMsg(sceneType = "audit.serviceVersion.publish")
    public void applyPublish(ParamA paramA, ParamB paramB) {
        log.info("applyPublish begin");
    }
    @AiPassiveMsg(sceneType = "audit.serviceVersion.publish.audit")
    public void approvePublish(ParamA paramA, ParamB paramB) {
        log.info("approvePublish begin");

    }
}
