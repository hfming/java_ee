package com.hfm.noioc;

import org.junit.Test;

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
    public void noIOCTest(){
        Account fromAccount = new Account(1, "hfm", new BigDecimal(9500));
        Account toAccount = new Account(2, "pdd", new BigDecimal(500));

        AccountServer accountServer = new AccountServerImpl();
        // 转账
        accountServer.transferAccount(fromAccount, toAccount, new BigDecimal(2000));
    }
}
