package org.lyflexi.strategypattern.strategyByAop.utils;

import org.springframework.beans.factory.Aware;
import org.springframework.core.io.ResourceLoader;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:54
 */
public interface ResourceLoaderAware extends Aware {
    void setResourceLoader(ResourceLoader var1);
}