package com.hfm.myioc.beans.factory.support;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 10:50
 * @Description 解析配置文件接口
 * @date 2021/10/16
 */
public interface BeanDefinitionReader {
    /**
     * 获取注册者
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 加载配置文件
     * @param configLoaction
     */
    void loadBeanDefinitions(String configLoaction);
}
