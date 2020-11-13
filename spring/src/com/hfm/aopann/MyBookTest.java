package com.hfm.aopann;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 17:20
 * @Description
 * @date 2020/9/29
 */
public class MyBookTest {
    /**
     * 注解及配置文件共同开发方式
     */
    @Test
    public void  xmlAndAnnoTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aopAnno.xml");

        MyBookDao myBookDao = context.getBean("myBookDaoImpl", MyBookDao.class);

        MyBook myBook = context.getBean("myBook", MyBook.class);
        myBook.setBookName("时间简史");
        myBook.setBookAuhtor("霍夫曼");

        myBookDao.add(myBook);
    }

    /**
     * 完全注解方式
     */
    @Test
    public void annoTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfie.class);

        MyBookDao myBookDao = context.getBean("myBookDaoImpl", MyBookDao.class);

        MyBook myBook = context.getBean("myBook", MyBook.class);
        myBook.setBookName("时间简史");
        myBook.setBookAuhtor("霍夫曼");

        myBookDao.add(myBook);
    }
}
