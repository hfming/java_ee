package com.hfm.mytransaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-14 17:37
 * @Description
 * @date 2021/10/14
 */
public class TransctionTest {
    /**
     * 不使用 IOC 进行数据库事务管理
     */
    @Test
    public void xmlTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mytransaction.xml");
        test(context);
    }

    @Test
    public void annoTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        test(context);
    }

    private void test(ApplicationContext context) {
        // 账号1
        Account fromAccount = context.getBean("account", Account.class);
        fromAccount.setAccountId(1);
        fromAccount.setAccountName("hfm");
        fromAccount.setBalance(new BigDecimal(9500));
        // 账号2
        Account toAccount = context.getBean("account", Account.class);
        toAccount.setAccountId(2);
        toAccount.setAccountName("pdd");
        toAccount.setBalance(new BigDecimal(500));

        AccountServerImpl accountServer = context.getBean("accountServer", AccountServerImpl.class);
//        // 转账
        accountServer.transferAccount(fromAccount, toAccount, new BigDecimal(2000));
    }
}
