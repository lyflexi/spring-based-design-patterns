package org.lyflexi.dutypattern.genericFactory;


import org.springframework.util.Assert;

import java.util.List;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/9/28 17:58
 */

public class ChainFactory<T,R> {
    AbstractHandler<T,R> firstHandler;
    //工厂版责任链,当使用ChainBuilder的时候，记得注释掉，否则会出现hanler的循环依赖，导致oom
    public ChainFactory (List<AbstractHandler<T,R>> handlers) {
        Assert.notEmpty(handlers,"handlers must not be empty");
        for (int i = 0;i< handlers.size() -1;i++) {
            handlers.get(i).setNextHandler(handlers.get(i+1));
        }
        firstHandler = handlers.get(0);
    }


    public R executeHandler (T t) {
        return firstHandler.doHandler(t);
    }



}
