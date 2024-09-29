package org.lyflexi.dutypattern.genericFactory.handler.robothandler;



import org.lyflexi.dutypattern.genericFactory.AbstractHandler;
import org.lyflexi.dutypattern.genericFactory.model.Robot;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:50
 */
@Component
@Order(2)
public class RobotHandler2 extends AbstractHandler<Robot,Boolean> {
    @Override
    public Boolean doHandler(Robot targetData) {
        if (!"admin".equals(targetData.getPermission())){
            System.out.println("Robot暂无权限");
            return false;
        }
        System.out.println("2.Robot权限校验通过");
        return super.handle(targetData);
    }
}

