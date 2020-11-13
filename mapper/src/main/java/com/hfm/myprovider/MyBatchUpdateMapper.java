package com.hfm.myprovider;

import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-28 11:36
 * @Description
 * @date 2020/10/28
 */
public interface MyBatchUpdateMapper<T> {
    /**
     * @param list
     * @UpdateProvider 注解 设置 Provider 的类及方法类型
     * type 属性 指定Provider 的属性
     * method 属性值固定 dynamicSQL
     */
    @UpdateProvider(type = MyBatchProvider.class, method = "dynamicSQL")
    void batchUpdate(List<T> list);
}
