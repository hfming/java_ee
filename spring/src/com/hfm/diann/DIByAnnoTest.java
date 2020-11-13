package com.hfm.diann;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-01 21:50
 * @Description 基于注解方式
 * @date 2020/10/1
 */
public class DIByAnnoTest {
    /**
     * 基于注解方式配置 bean
     */
    @Test
    public void createBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("diAnno.xml");

        EmployeeServer employeeServer = context.getBean("employeeServerImpl", EmployeeServer.class);
        Employee employee = context.getBean("employee", Employee.class);

        employeeServer.add(employee);
    }

    /**
     * 属性注入的4 种注解
     */
    @Test
    public void diTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("diAnno.xml");

        DI di = context.getBean("di", DI.class);

        System.out.println(di.getName());

        System.out.println(di.getEmployeeServer().getClass());
        System.out.println(di.getEmployeeDao().getClass());
        System.out.println(di.getEmployeeDao2().getClass());

        context.close();
    }

    /**
     * 对象,对象 list,对象 set ,对象 map 集合属性的注入
     */
    @Test
    public void auotTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("diAnno.xml");

        BookList autoDi = context.getBean("bookList", BookList.class);

        System.out.println("对象");
        // 对象
        System.out.println(autoDi.getBook());
        System.out.println(autoDi.getString());

        // 对象数组
        System.out.println(Arrays.toString(autoDi.getBooks()));
        System.out.println(Arrays.toString(autoDi.getStrings()));

        System.out.println("对象 list 集合");
        // 对象list 集合
        for (Book book : autoDi.getBookList()) {
            System.out.println(book);
        }

        System.out.println("对象 set 集合");
        for (Book book : autoDi.getBookSet()) {
            System.out.println(book);
        }

        System.out.println("对象 map 集合");
        for (Map.Entry<String, Book> stringBookEntry : autoDi.getBookMap().entrySet()) {
            System.out.print(stringBookEntry.getKey() + "\t");
            System.out.println(stringBookEntry.getValue());
        }
    }

    /**
     * 完全注解式开发
     */
    @Test
    public void annotationTest() {
        // 加载配置文件类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigure.class);

        EmployeeServer employeeServer = context.getBean("employeeServerImpl", EmployeeServer.class);

        Employee employee = context.getBean("employee", Employee.class);

        employeeServer.add(employee);
    }
}
