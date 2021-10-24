package com.hfm.myioc.beans.factory;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 11:16
 * @Description IOC 容器类接口
 * @date 2021/10/16
 */
public interface BeanFactory {
    /**
     * 根据名称获取 Bean 对象
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;

    <T> T getBean(String name, Class<? extends T>clazz) throws Exception;
}
