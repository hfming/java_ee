package com.hfm.myioc.context;

import com.hfm.myioc.beans.factory.xml.XmLBeanDefinitionReader;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 11:20
 * @Description
 * @date 2021/10/16
 */
public class ClassPathXMLApplicationContext extends AbstractApplicationContext {
    public ClassPathXMLApplicationContext(String configLocation) {
        this.configLocation = configLocation;
        xmLBeanDefinitionReader = new XmLBeanDefinitionReader();

        try {
            this.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
