package com.hfm.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 11:48
 * @Description
 * @date 2020/10/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MySelect {
    /**
     * 配置 Sql 语句
     *
     * @return
     */
    String value();
}
