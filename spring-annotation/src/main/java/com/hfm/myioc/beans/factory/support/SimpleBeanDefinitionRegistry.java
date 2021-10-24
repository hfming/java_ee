package com.hfm.myioc.beans.factory.support;

import com.hfm.myioc.beans.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 10:41
 * @Description
 * @date 2021/10/16
 */
public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry{
    /**
     * 定义 IOC 容器用于存储 BeanDefinition 对象
     */
    private Map<String, BeanDefinition> beanMap = new ConcurrentHashMap<>();

    @Override
    public void registerBeanpefinition(String beanName, BeanDefinition beanDefinition) {
        beanMap.put(beanName, beanDefinition);
    }

    @Override
    public void removeBeanDefinition(String beanName) throws Exception {
        beanMap.remove(beanMap.get(beanName));
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws Exception {
        return beanMap.get(beanName);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanMap.containsKey(beanName);
    }

    @Override
    public int getBeanpefinitioncount() {
        return beanMap.size();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanMap.keySet().toArray(new String[0]);
    }
}
