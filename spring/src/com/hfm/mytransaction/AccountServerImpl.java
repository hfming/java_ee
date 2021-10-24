package com.hfm.mytransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-30 11:18
 * @Description
 * @date 2020/9/30
 */
@Service(value = "accountServer")
public class AccountServerImpl implements AccountServer {
    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transferAccount(Account fromAccount, Account toAccount, BigDecimal money) {
        /**
         * 模拟转账出现问题
         */
//        int i = 10 / 0;
        accountDao.transferAccount(fromAccount, toAccount, money);
    }
}
