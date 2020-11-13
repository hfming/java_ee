package com.hfm.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-14 21:20
 * @Description
 * @date 2020/10/14
 */
@Component(value = "myBean")
public class MyBean implements InitializingBean, DisposableBean {
    private String name;

    public MyBean() {
        System.out.println("构造函数");
    }

    public MyBean(String name) {
        this.name = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化方法");
    }
}
