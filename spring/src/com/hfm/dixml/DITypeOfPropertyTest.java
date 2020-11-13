package com.hfm.dixml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-01 20:26
 * @Description 复杂数据类型属性注入 与 属性注入的细节
 * @date 2020/10/1
 */
public class DITypeOfPropertyTest {
    @Test
    public void createBean() {
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("diXml.xml");

        //2 获取配置创建的对象
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    /**
     * 字面量注入
     */
    @Test
    public void stringTest() {
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("diXml.xml");

        //2 获取配置创建的对象
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    /**
     * 外部注入方式注入 bean 类型属性
     */
    @Test
    public void outterBeanTest() {
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("diXml.xml");

        //2 获取配置创建的对象
        BookServer bookServer = context.getBean("bookServer", BookServer.class);
        Book book = context.getBean("book", Book.class);

        bookServer.addBook(book);
    }

    /**
     * 内部注入方式注入 bean 类型属性
     */
    @Test
    public void innerBeanTest() {
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("diXml.xml");

        //2 获取配置创建的对象
        Employee employee = context.getBean("employee", Employee.class);

        System.out.println(employee);
        System.out.println(employee.getDept());
    }

    /**
     * 复合数据类型属性注入
     * String 数组,对象数组,String list 集合,对象 list 集合,String set 集合,对象 set 集合,String map 集合,对象 map 集合 类型属性注入
     */
    @Test
    public void CompositePropertyTest() {
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("diXml.xml");

        //2 获取配置创建的对象
        BookCompositeProperty stu = context.getBean("bookCompositeProperty", BookCompositeProperty.class);

        // String 数组
        System.out.println(Arrays.toString(stu.getCourses()));

        // 对象数组
        for (Book book : stu.getBooks()) {
            System.out.println(book);
        }
        // String List 集合
        System.out.println(stu.getStrings());

        // 对象 List 集合
        System.out.println(stu.getBookList());

        // String set 集合
        for (String set : stu.getSets()) {
            System.out.println(set);
        }

        // 对象 set 集合
        System.out.println(stu.getBookSet());

        // String map 集合
        for (Map.Entry<String, String> entry : stu.getMaps().entrySet()) {
            System.out.print(entry.getKey() + "\t");
            System.out.println(entry.getValue());
        }

        // 对象 map 集合
        for (Map.Entry<Integer, Book> integerBookEntry : stu.getBookMap().entrySet()) {
            System.out.print(integerBookEntry.getKey() + "\t");
            System.out.println(integerBookEntry.getValue());
        }
    }

    /**
     * 集合的抽取与复用
     */
    @Test
    public void listTest() {
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("list.xml");

        //2 获取配置创建的对象
        BookList bookList = context.getBean("bookList", BookList.class);

        // list 集合
        System.out.println(bookList.getBookList());

        // set 集合
        for (Book book : bookList.getBookSet()) {
            System.out.println(book);
        }

        // map 集合
        for (Map.Entry<Integer, Book> integerBookEntry : bookList.getBookMap().entrySet()) {
            System.out.print(integerBookEntry.getKey() + "\t");
            System.out.println(integerBookEntry.getValue());
        }
    }
}
