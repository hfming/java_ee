package com.hfm.config;

import com.hfm.domain.Person;
import com.hfm.typefilter.MyTypeFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-13 22:34
 * @Description
 * @date 2020/10/13
 */
@Configurable  // 作为配置类,替代 xml 配置文件,告诉配置 Spring 这是一个配置类
@ComponentScan(
        basePackages = {"com.hfm.domain"}, // 配置组件扫描的路径
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}, // 配置不扫描的注解
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {ComponentScan.class}), // 只扫描带有 @ComponentScan 注解的类
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Person.class}), // 扫描指定的类
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})}, // 使用自定义类型过滤器
        useDefaultFilters = false // 不使用默认过滤器
)
public class SpringConfigure {

}
