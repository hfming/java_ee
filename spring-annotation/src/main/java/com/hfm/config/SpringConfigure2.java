package com.hfm.config;

import com.hfm.condition.MyCondition;
import com.hfm.domain.Person;
import com.hfm.imports.MyImportBeanDefinitionRegistrar;
import com.hfm.imports.MyImportSelector;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-14 10:52
 * @Description
 * @date 2020/10/14
 */
@Configurable
@ComponentScan(basePackages = {"com.hfm.domain"})
@Import({Person.class,  // 导入 bean,ioc 容器会自动注册 bean 默认是全类名
        MyImportSelector.class, // 使用导入选择器，导入选择器中的返回的数组中的类也会导入 ioc 容器
        MyImportBeanDefinitionRegistrar.class // 使用 bean 注册器手动注册bean
})
@PropertySource(value = {"classpath:jdbc.properties"})
public class SpringConfigure2 {
    /**
     * ConfigurableBeanFactory.SCOPE_PROTOTYPE prototype 原型 多实例 ioc 启动时不会创建对象，而是每次获取对象时才会调用方法创建对象
     * ConfigurableBeanFactory.SCOPE_SINGLETON single 单实例(默认) ioc 启动时会调用方法创建对象并放入容器中，以后每次都从 ioc 容器中取对象
     * request 同一个请求创建一个实例
     * session 同一个session 创建一个实例
     *
     * @return
     */
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy // 懒加载，对单实例对象来说IOC 启动时不再直接创建对象，而是在第一次启动时调用方法创建对象。对多实例对象无效
    @Bean(initMethod = "init",destroyMethod = "destory") // initMethod 与 destroyMethod 属性定义 初始化方法与 销毁方法
    public Person getPerson() {
        return new Person(1, "hfm", "17111711");
    }

    @Conditional({MyCondition.class})
    @Bean
    public Person getPerson2() {
        return new Person(1, "hfm", "17111711");
    }
}
