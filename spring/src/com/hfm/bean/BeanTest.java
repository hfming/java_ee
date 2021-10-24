package com.hfm.bean;

import com.hfm.dixml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 12:19
 * @Description bean 对象详解
 * @date 2020/9/28
 */
public class BeanTest {
    /**
     * 通过默认无参构造函数创建 bean 对象
     * 如果没有无参构造函数会报错
     */
    @Test
    public void createBean1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDetial.xml");

        MyBean myBean = context.getBean("myBean", MyBean.class);
        System.out.println(myBean);
    }

    /**
     * 通过实例工厂创建 bean 对象
     */
    @Test
    public void createBean2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDetial.xml");

        MyBean myBean = context.getBean("myBean", MyBean.class);
        System.out.println(myBean);
    }

    /**
     * 通过静态工厂创建 bean 对象
     */
    @Test
    public void createBean3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDetial.xml");

        MyBean myBean = context.getBean("myBean", MyBean.class);
        System.out.println(myBean);
    }

    /**
     * Factory 接口测试
     * @throws Exception
     */
    @Test
    public void factoryTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDetial.xml");

        // 创建的是 Bean 对象不是 FactoryBean 对象,通过工厂类创建 bean 对象
        Book book = context.getBean("bookFactory", Book.class);
        System.out.println(book);
    }

    /**
     * bean 的作用域
     */
    @Test
    public void singleBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDetial.xml");

        // 创建的是 Bean 对象不是 FactoryBean 对象,通过工厂类创建 bean 对象
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);

        // 默认为单实例, 修改 scope 属性为prototype ,则为多实例
        System.out.println(book1 == book2);
    }

    /**
     * bean 生命周期测试
     */
    @Test
    public void lifeTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanDetial.xml");

        LifeBean lifeBean = context.getBean("lifeBean", LifeBean.class);
        System.out.println("4 创建 bean 对象");
        System.out.println(lifeBean);

        // 手动销毁
        context.close();
    }

    /**
     *后置处理器与 bean 生命周期的关系
     */
    @Test
    public void beanPostProcessorTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanDetial.xml");

        LifeBean lifeBean  = context.getBean("lifeBean", LifeBean.class);
        System.out.println("6 创建 bean 对象");
        System.out.println(lifeBean);

        context.close();
    }
}
