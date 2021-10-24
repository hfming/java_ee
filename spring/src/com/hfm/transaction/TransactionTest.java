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

        // 安全注解式开发
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigure.class);

        AccountServer accountServer = context.getBean("accountServerImpl", AccountServer.class);
        // 账户1
        Account fromAccount = context.getBean("account", Account.class);
        fromAccount.setAccountId(1);
        fromAccount.setBalance(new BigDecimal(9500));
        fromAccount.setAccountName("hfm");
        // 账户2
        Account toAccount = context.getBean("account", Account.class);
        toAccount.setAccountId(2);
        toAccount.setBalance(new BigDecimal(500));
        toAccount.setAccountName("pdd");

        // 转账 500
        accountServer.transferAccount(fromAccount, toAccount, new BigDecimal(500));
    }
}
