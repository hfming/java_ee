package com.hfm.myioc.context;

import com.hfm.myioc.beans.BeanDefinition;
import com.hfm.myioc.beans.MutablePropertyValues;
import com.hfm.myioc.beans.PropertyValue;
import com.hfm.myioc.beans.factory.support.BeanDefinitionRegistry;
import com.hfm.myioc.beans.factory.xml.XmLBeanDefinitionReader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 11:23
 * @Description
 * @date 2021/10/16
 */
public abstract class AbstractApplicationContext implements ApplacationContext {
    /**
     * 声明解析器
     */
    protected XmLBeanDefinitionReader xmLBeanDefinitionReader;

    /**
     * 存储 Bean 对象的容器
     */
    protected Map<String, Object> beanMap = new ConcurrentHashMap<>();
    /**
     * 配置文件路径
     */
    protected String configLocation;
    private Class<?> aClass;

    @Override
    public void refresh() throws Exception {
        // 加载 Bean 对象
        xmLBeanDefinitionReader.loadBeanDefinitions(configLocation);
        // 初始化 Bean
        finishBeanInitialization();
    }

    private void finishBeanInitialization() throws Exception {
        // 或 BeanDefinitionRegistry 注册表
        BeanDefinitionRegistry registry = xmLBeanDefinitionReader.getRegistry();

        String[] beanDefinitionNames = registry.getBeanDefinitionNames();

        // bean 的初始化
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = getBean(beanDefinitionName);

            if (bean != null) {
                // 加入到 IOC 容器
                this.beanMap.put(beanDefinitionName, bean);
            }
        }
    }

    @Override
    public Object getBean(String name) throws Exception {
        return getObject(name);
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        return (T) getObject(name);
    }

    /**
     * 通过反射创建对象并设置属性
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Object getObject(String name) throws Exception {
        Object bean = null;
        BeanDefinitionRegistry registry = this.xmLBeanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
        // 获取全类名
        String className = beanDefinition.getClassName();
        if (className != null) {
            // 通过反射创建对象
            aClass = Class.forName(className);
            bean = aClass.newInstance();

            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            // 设置属性
            for (PropertyValue propertyValue : propertyValues) {
                // 属性值
                String value = propertyValue.getValue();
                // 另外的 bean
                String propertyRef = propertyValue.getRef();
                // 属性名
                String propertyName = propertyValue.getName();

                Field[] declaredFields = aClass.getDeclaredFields();
                // 遍历设置属性
                for (Field declaredField : declaredFields) {
                    // 暴力反射
                    declaredField.setAccessible(true);
                    // 属性名相同
                    if (declaredField.getName().equalsIgnoreCase(propertyName)) {
                        if (declaredField.getGenericType().toString().equals("int")||declaredField.getGenericType().toString().equals("class java.lang.Integer")){
                            // int 型属性
                            declaredField.set(bean, Integer.parseInt(value));
                        }else if(declaredField.getGenericType().toString().equals("class java.lang.String")){
                            // String 型属性
                            declaredField.set(bean, value);
                        }else{
                            // Bean 型属性
                            declaredField.set(bean,getBean(propertyRef));
                        }
                    }
                }
            }
            return bean;
        }
        return null;
    }
}
