package com.hfm.myioc.beans;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 10:29
 * @Description Bean 标签类
 * @date 2021/10/16
 */
public class BeanDefinition {
    /**
     * Bean id
     */
    private String id;

    /**
     * 包名 + 类名
     */
    private String className;

    /**
     * 所有属性
     */
    private MutablePropertyValues propertyValues;

    public BeanDefinition() {
        propertyValues = new MutablePropertyValues();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public MutablePropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(MutablePropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
