package org.lyflexi.dutypattern.genericFactory.handler.robothandler;

import org.apache.commons.lang3.StringUtils;

import org.lyflexi.dutypattern.genericFactory.AbstractHandler;
import org.lyflexi.dutypattern.genericFactory.model.Robot;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:32
 */

@Component
@Order(1)
public class RobotHandler1 extends AbstractHandler<Robot,Boolean> {
    @Override
    public Boolean doHandler(Robot targetData) {
        if (StringUtils.isBlank(targetData.getRobotName())){
            System.out.println("Robot机器人名不能为空");
            return false;
        }
        if (StringUtils.isBlank(targetData.getRobotType())){
            System.out.println("Robot机器类型不能为空");
            return false;
        }
        System.out.println("1.Robot名称类型校验通过");
        return super.handle(targetData);
    }
}

