package com.hfm.myioc.beans.factory.support;

import com.hfm.myioc.beans.BeanDefinition;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 10:37
 * @Description 注册表行为
 * @date 2021/10/16
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册BeanDefinition对象到注册表中
     */
    void registerBeanpefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 从去册表中删除指定名称的BeanDefinition对象
     *
     * @param beanName
     * @throws Exception
     */
    void removeBeanDefinition(String beanName) throws Exception;

    /**
     * 根据名称从注册表中获取BeanDefinition对象
     *
     * @param beanName
     * @return
     * @throws Exception
     */
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    boolean containsBeanDefinition(String beanName);

    int getBeanpefinitioncount();

    String[] getBeanDefinitionNames();
}
