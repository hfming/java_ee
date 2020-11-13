package com.hfm.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-30 11:18
 * @Description
 * @date 2020/9/30
 */
public class TransactionTest {
    /**
     * 数据库事务
     */
    @Test
    public void txTest(){
        Account fromAccount = new Account(1, "hfm", new BigDecimal(9500));
        Account toAccount = new Account(2, "pdd", new BigDecimal(500));

        // 安全注解式开发
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigure.class);

        AccountServer accountServer = context.getBean("accountServerImpl", AccountServer.class);

        // 转账 500
        accountServer.transferAccount(fromAccount, toAccount, new BigDecimal(500));
    }

    /**
     * 函数式风格
     */
//    @Test
//    public void genericApplicationContextTest(){
//        //1 创建GenericApplicationContext对象
//        GenericApplicationContext context = new GenericApplicationContext();
//        //2 调用context的方法对象注册
//        context.refresh();
//        context.registerBean("user1", User.class,() -> new User());
//        //3 获取在spring注册的对象
//        // User user = (User)context.getBean("com.atguigu.spring5.test.User");
//        User user = (User)context.getBean("user1");
//        System.out.println(user);
//    }
}
