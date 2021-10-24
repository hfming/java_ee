package com.hfm.myioc.beans.factory.xml;

import com.hfm.myioc.beans.BeanDefinition;
import com.hfm.myioc.beans.MutablePropertyValues;
import com.hfm.myioc.beans.PropertyValue;
import com.hfm.myioc.beans.factory.support.BeanDefinitionReader;
import com.hfm.myioc.beans.factory.support.BeanDefinitionRegistry;
import com.hfm.myioc.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 10:51
 * @Description
 * @date 2021/10/16
 */
public class XmLBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * 声明注册表对象
     */
    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmLBeanDefinitionReader() {
        this.beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
    }

    public XmLBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return beanDefinitionRegistry;
    }

    /**
     * 使用 Dom4j 进行 Xml 解析
     *
     * @param configLoaction
     */
    @Override
    public void loadBeanDefinitions(String configLoaction) {
        try {
            SAXReader saxReader = new SAXReader();

            // 获取类路径下的xml 文件
            InputStream resourceAsStream = XmLBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLoaction);

            Document document = saxReader.read(resourceAsStream);
            // 根标签
            Element rootElement = document.getRootElement();

            List<Element> beans = rootElement.elements("bean");
            for (Element bean : beans) {
                // id 属性
                String id = bean.attributeValue("id");
                // class 属性
                String aClass = bean.attributeValue("class");

                // 创建 BeanDefinition
                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setId(id);
                beanDefinition.setClassName(aClass);
                // 获取所有属性
                List<Element> propertys = bean.elements("property");
                MutablePropertyValues propertyValues = new MutablePropertyValues();
                for (Element property : propertys) {
                    String name = property.attributeValue("name");
                    String ref = property.attributeValue("ref");
                    String value = property.attributeValue("value");

                    PropertyValue propertyValue = new PropertyValue(name, value, ref);

                    propertyValues.addPorpertyValue(propertyValue);
                }
                // Bean 对象中转入属性
                beanDefinition.setPropertyValues(propertyValues);

                // 注册 Bean
                this.beanDefinitionRegistry.registerBeanpefinition(id, beanDefinition);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
