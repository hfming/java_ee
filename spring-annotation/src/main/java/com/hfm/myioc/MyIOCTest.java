package com.hfm.myioc;

import com.hfm.domain.Person;
import com.hfm.myioc.context.ClassPathXMLApplicationContext;
import org.junit.jupiter.api.Test;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 11:37
 * @Description
 * @date 2021/10/16
 */
public class MyIOCTest {
    @Test
    public void myIOCTest() throws Exception {
        ClassPathXMLApplicationContext context = new ClassPathXMLApplicationContext("myioc.xml");

        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }
}
