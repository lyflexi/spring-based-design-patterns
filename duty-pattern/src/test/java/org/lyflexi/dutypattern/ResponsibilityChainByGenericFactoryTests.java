package org.lyflexi.dutypattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.lyflexi.dutypattern.genericFactory.ChainFactory;
import org.lyflexi.dutypattern.genericFactory.model.LoginUser;
import org.lyflexi.dutypattern.genericFactory.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 策略模式：基于InitializingBean 与手写策略工厂
 */
@SpringBootTest
@Slf4j
class ResponsibilityChainByGenericFactoryTests {

    @Qualifier("robotChainFactory")
    @Autowired
    ChainFactory robotChainFactory;

    @Qualifier("loginUserChainFactory")
    @Autowired
    ChainFactory loginUserChainFactory;




    @Test
    void contextLoads() {
        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");
        loginUserChainFactory.executeHandler(loginUser);



        Robot robot = new Robot();
        robot.setRobotName("机器人1号");
        robot.setRobotType("铁质机器人");
        robot.setRoleName("admin");
        robot.setPermission("admin");
        robotChainFactory.executeHandler(robot);



    }

}
