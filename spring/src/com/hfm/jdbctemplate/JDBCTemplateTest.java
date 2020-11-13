package com.hfm.jdbctemplate;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 20:28
 * @Description
 * @date 2020/9/29
 */
public class JDBCTemplateTest {
    @Test
    public void addBookTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");

        // 创建实体类
        NBook nBook = context.getBean("nBook", NBook.class);
        System.out.println(nBook);

        // 创建 Server 实现类
        NbookServer nBookServerImpl = context.getBean("nBookServerImpl", NbookServer.class);

        // 添加
        nBookServerImpl.addBook(nBook);
    }

    @Test
    public void updateBookTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");

        // 创建 Server 实现类
        NbookServer nBookServerImpl = context.getBean("nBookServerImpl", NbookServer.class);

        NBook nBook = nBookServerImpl.findNBookById(2);
        nBook.setBookName("泰坦尼克号");
        System.out.println(nBook);

        nBookServerImpl.updateBook(nBook);
    }

    @Test
    public void deleteBookTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");

        // 创建 Server 实现类
        NbookServer nBookServerImpl = context.getBean("nBookServerImpl", NbookServer.class);

        nBookServerImpl.deleteBook(2);
    }

    @Test
    public void countTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");

        // 创建 Server 实现类
        NbookServer nBookServerImpl = context.getBean("nBookServerImpl", NbookServer.class);

        System.out.println(nBookServerImpl.count());
    }

    @Test
    public void nBooksTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");

        // 创建 Server 实现类
        NbookServer nBookServerImpl = context.getBean("nBookServerImpl", NbookServer.class);

        for (NBook nBook : nBookServerImpl.nBooks()) {
            System.out.println(nBook);
        }
    }

    @Test
    public void findNBookByIdTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");

        // 创建 Server 实现类
        NbookServer nBookServerImpl = context.getBean("nBookServerImpl", NbookServer.class);

        NBook nBook = nBookServerImpl.findNBookById(2);
        System.out.println(nBook);
    }

    @Test
    public void findNBookByNameTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");

        // 创建 Server 实现类
        NbookServer nBookServerImpl = context.getBean("nBookServerImpl", NbookServer.class);

        NBook nbook = nBookServerImpl.findNBookByName("泰坦尼克号");
        System.out.println(nbook);
    }

    @Test
    public void banthAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");

        // 创建 Server 实现类
        NbookServer nBookServerImpl = context.getBean("nBookServerImpl", NbookServer.class);

        List<NBook> nBooks = nBookServerImpl.nBooks();

        nBookServerImpl.banthAdd(nBooks);
    }
}