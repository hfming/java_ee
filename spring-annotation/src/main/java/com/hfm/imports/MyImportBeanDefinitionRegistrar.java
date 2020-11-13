package com.hfm.imports;

import com.hfm.domain.Person;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-14 20:17
 * @Description 自定义导入 bean 注册器
 * @date 2020/10/14
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param annotationMetadata     当前类的bean 的注解信息
     * @param beanDefinitionRegistry 注册类，调用 registerBeanDefinitions 方法把所有需要添加到ioc 容器中的bean手动注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean person = beanDefinitionRegistry.containsBeanDefinition("Person");

        // 指定bean 的类型
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Person.class);
        // 如果是 person 则注册进ioc 容器中
        if (person) {
            // 注册一个 bean ,并指定一个 bean 名称
            beanDefinitionRegistry.registerBeanDefinition("person", rootBeanDefinition);
        }
    }
}
