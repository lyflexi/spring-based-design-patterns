package org.lyflexi.dutypattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.lyflexi.dutypattern.genericBuilder.AbstractHandler;
import org.lyflexi.dutypattern.genericBuilder.ChainBuilder;
import org.lyflexi.dutypattern.genericBuilder.handler.robothandler.RobotHandler1;
import org.lyflexi.dutypattern.genericBuilder.handler.robothandler.RobotHandler2;
import org.lyflexi.dutypattern.genericBuilder.handler.robothandler.RobotHandler3;
import org.lyflexi.dutypattern.genericBuilder.handler.userhandler.VerifyAccountHandler;
import org.lyflexi.dutypattern.genericBuilder.handler.userhandler.VerifyPermissionHanlder;
import org.lyflexi.dutypattern.genericBuilder.handler.userhandler.VerifyRoleHanlder;
import org.lyflexi.dutypattern.genericBuilder.model.Robot;
import org.lyflexi.dutypattern.genericBuilder.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 策略模式：基于InitializingBean 与手写策略工厂
 */
@SpringBootTest
@Slf4j
class ResponsibilityChainByGenericBuilderTests {
    
    @Qualifier("loginUserChainBuilder")
    @Autowired
    ChainBuilder loginUserChainBuilder;
    @Autowired
    VerifyAccountHandler verifyAccountHandler;
    @Autowired
    VerifyPermissionHanlder verifyPermissionHanlder;
    @Autowired
    VerifyRoleHanlder verifyRoleHanlder;


    @Qualifier("robotChainBuilder")
    @Autowired
    ChainBuilder robotChainBuilder;
    @Autowired
    RobotHandler1 robotHandler1;
    @Autowired
    RobotHandler2 robotHandler2;
    @Autowired
    RobotHandler3 robotHandler3;
    @Test
    void builderLoads() {
        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");
        AbstractHandler<LoginUser,Boolean> firstLoginUserHandler = loginUserChainBuilder.addHanlder(verifyAccountHandler).addHanlder(verifyPermissionHanlder).addHanlder(verifyRoleHanlder).build();
        firstLoginUserHandler.doHandler(loginUser);

        Robot robot = new Robot();
        robot.setRobotName("机器人1号");
        robot.setRobotType("铁质机器人");
        robot.setRoleName("admin");
        robot.setPermission("admin");
        AbstractHandler<Robot,Boolean> firstRobotHandler = robotChainBuilder.addHanlder(robotHandler1).addHanlder(robotHandler2).addHanlder(robotHandler3).build();
        firstRobotHandler.doHandler(robot);



    }
}
