package com.hfm.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-15 21:52
 * @Description 自动装配
 * @date 2021/10/15
 */
@Component
public class MyAware implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext applicationContext;
    @Override
    public void setBeanName(String s) {
        // 当前 Bean 的名称
        System.out.println(s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // IOC 容器
        System.out.println(applicationContext);
        this.applicationContext = applicationContext;
    }
}
