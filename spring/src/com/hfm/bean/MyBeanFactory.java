package com.hfm.bean;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-01 17:31
 * @Description 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 * @date 2020/10/1
 */
public class MyBeanFactory {
    public MyBean getMyBean() {
        return new MyBean();
    }
}
