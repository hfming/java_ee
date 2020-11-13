package com.hfm.bean;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 12:41
 * @Description
 * @date 2020/9/28
 */
public class LifeBean {
    private String name;

    public LifeBean() {
        System.out.println("1 构造函数");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LifeBean{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2 对属性进行赋值");
    }

    /**
     * 创建执行的初始化的方法
     */
    public void initMethod() {
        System.out.println("4 执行初始化的方法");
    }

    /**
     * 创建执行的销毁的方法
     */
    public void destroyMethod() {
        System.out.println("7 执行销毁的方法");
    }
}
