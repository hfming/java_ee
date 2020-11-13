package com.hfm.test;

import com.hfm.transaction.AccountServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-30 17:08
 * @Description
 * @date 2020/9/30
 */
@RunWith(SpringJUnit4ClassRunner.class) // 指定使用测试框架的版本
@ContextConfiguration(value = "classpath:transactionAnno.xml") // 指定加载配置文件
public class Junit4Test {
    @Autowired
    private AccountServer accountServer;

    @Test
    public void junitTest() {
        System.out.println(accountServer);
    }
}
