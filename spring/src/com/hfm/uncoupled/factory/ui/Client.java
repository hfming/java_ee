package com.hfm.uncoupled.factory.ui;

import com.hfm.uncoupled.factory.beanfactory.BeanFactory;
import com.hfm.uncoupled.factory.dao.IAccountDao;
import com.hfm.uncoupled.factory.service.IAccountService;
import org.junit.Test;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }

    @Test
    public void test() {
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
        System.out.println(as);
        IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
        System.out.println(accountDao);
    }
}
