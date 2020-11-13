package com.hfm.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-14 11:18
 * @Description 自定义条件
 * @date 2020/10/14
 */
public class MyCondition implements Condition {
    /**
     * ConditionContext 判断条件能使用的上下文(运行环境)
     * AnnotatedTypeMetadata 注解的信息
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 获取当前 IOC 容器的 bean 工厂
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();

        // 获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();

        // 获取 bean 定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        // 获取运行环境
        Environment environment = conditionContext.getEnvironment();

        String os = environment.getProperty("os.name");
        // 如果操作相同为 windows 则条件通过
        if (os.contains("Windows")){
            return true;
        }
        return false;
    }
}
