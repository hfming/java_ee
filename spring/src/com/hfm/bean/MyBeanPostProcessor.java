package com.hfm.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 16:28
 * @Description 自定义后置处理器
 * @date 2020/9/28
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3 创建 bean 前");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5 创建 bean 后");
        return bean;
    }
}
