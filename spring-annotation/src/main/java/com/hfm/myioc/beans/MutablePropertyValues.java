package com.hfm.myioc.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 10:09
 * @Description 多个 PropertyValue 的集合
 * @date 2021/10/16
 */
public class MutablePropertyValues implements Iterable<PropertyValue> {
    private List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList != null) {
            this.propertyValueList = propertyValueList;
        } else {
            propertyValueList = new ArrayList<>();
        }
    }

    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }

    /**
     * 以数组形式获取所有顺属性
     *
     * @return
     */
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据名称获取属性
     *
     * @param name
     * @return
     */
    public PropertyValue getPorpertyValueByName(String name) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equalsIgnoreCase(name)) {
                return propertyValue;
            }
        }
        return null;
    }

    /**
     * 判断集合是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    /**
     * 链式编程
     * 添加属性
     *
     * @param propertyValue
     * @return
     */
    public MutablePropertyValues addPorpertyValue(PropertyValue propertyValue) {
        if (propertyValue != null) {
            // 重复了不添加
            boolean flag = false;
            for (PropertyValue value : this.propertyValueList) {
                if (value.getName().equalsIgnoreCase(propertyValue.getName())) {
                    flag = true;
                    value.setValue(propertyValue.getValue());
                    return this;
                }
            }
        }
        this.propertyValueList.add(propertyValue);
        return this;
    }

    /**
     * 输出属性
     *
     * @param propertyValue
     * @return
     */
    public MutablePropertyValues removePropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.remove(propertyValue);
        return this;
    }

    /**
     * 是否存在指定属性名的属性
     *
     * @param name
     * @return
     */
    public boolean contains(String name) {
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
