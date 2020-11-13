package com.hfm.aopxml;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 17:45
 * @Description
 * @date 2020/9/29
 */
public class NewBookTest {
    @Test
    public  void aopXmlTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aopXml.xml");

        NewBookDao newBookDao = context.getBean("newBookDao", NewBookDao.class);

        NewBook newBook = context.getBean("newBook", NewBook.class);

        newBookDao.add(newBook);
    }
}
