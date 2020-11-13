package com.hfm.test;

import com.hfm.transaction.AccountServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-30 17:17
 * @Description
 * @date 2020/9/30
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:transactionAnno.xml")
public class Junit5Test {
    @Autowired
    private AccountServer accountServer;

    @Test
    public void junitTest() {
        System.out.println(accountServer);
    }
}
