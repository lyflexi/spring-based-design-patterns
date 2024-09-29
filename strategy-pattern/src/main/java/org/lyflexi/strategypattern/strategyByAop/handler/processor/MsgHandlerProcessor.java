package org.lyflexi.strategypattern.strategyByAop.handler.processor;

import com.google.common.collect.Maps;

import org.lyflexi.strategypattern.strategyByAop.annotation.PassiveMsgHandlerType;
import org.lyflexi.strategypattern.strategyByAop.handler.annotationHander.MsgHandlerContext;
import org.lyflexi.strategypattern.strategyByAop.utils.ClassScaner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:53
 */
@Component
public class MsgHandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "org.lyflexi.strategypattern.strategyByAop";

    /*
     * 扫描@PassiveMsgHandlerType，MsgHandlerContext，将其注册到spring容器
     *
     * @param beanFactory bean工厂
     */

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class<? extends Annotation>> handlerMap = Maps.newHashMapWithExpectedSize(3);
        //只扫描带有@PassiveMsgHandlerType注解的handler
        ClassScaner.scan(HANDLER_PACKAGE, PassiveMsgHandlerType.class).forEach(clazz -> {
            // 获取注解中的类型值
            String type = clazz.getAnnotation(PassiveMsgHandlerType.class).value();
            // 将注解中的类型值作为key，对应的类作为value，保存在Map中
            handlerMap.put(type, (Class<? extends Annotation>) clazz);
            beanFactory.registerSingleton(clazz.getName(),clazz);
        });
        // 创建自己的HandlerContext，也将其注册到spring容器中，HandlerContext用于后续获取handler
        MsgHandlerContext context = new MsgHandlerContext(handlerMap);
        beanFactory.registerSingleton(MsgHandlerContext.class.getName(), context);
    }

}