package org.lyflexi.dutypattern.genericBuilder.handler.userhandler;

import org.apache.commons.lang3.StringUtils;

import org.lyflexi.dutypattern.genericBuilder.AbstractHandler;
import org.lyflexi.dutypattern.genericBuilder.model.LoginUser;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:32
 */

@Component
@Order(1)
public class VerifyAccountHandler extends AbstractHandler<LoginUser,Boolean> {
    @Override
    public Boolean doHandler(LoginUser targetData) {
        if (StringUtils.isBlank(targetData.getLoginName())){
            System.out.println("LoginUser用户名不能为空");
            return false;
        }
        if (StringUtils.isBlank(targetData.getPassword())){
            System.out.println("LoginUser密码不能为空");
            return false;
        }
        if (!targetData.getPassword().equals("123456")){
            System.out.println("LoginUser密码不正确");
            return false;
        }
        System.out.println("1.LoginUser账号密码校验通过");
        return super.handle(targetData);
    }
}

