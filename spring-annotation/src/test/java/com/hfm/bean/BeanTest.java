package com.hfm.bean;

import com.hfm.config.FirstConfigure;
import com.hfm.config.SpringConfigure;
import com.hfm.config.SpringConfigure2;
import com.hfm.aware.Bean;
import com.hfm.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-13 22:51
 * @Description
 * @date 2020/10/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FirstConfigure.class)
public class BeanTest {
    @Test
    public void createTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigure.class);

        Person person = context.getBean("person", Person.class);
        System.out.println(person);

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);

        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }

    @Test
    public void beanTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FirstConfigure.class);

        Bean myBean = context.getBean("bean", Bean.class);

        context.close();
    }
    @Test
    public void beanTest3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigure2.class);

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);

        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}