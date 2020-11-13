package com.hfm.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-30 11:18
 * @Description
 * @date 2020/9/30
 */
@Service(value = "accountServerImpl")
// @Transactional 这个注解添加到类上面，也可以添加方法上面。如果把这个注解添加类上面，这个类里面所有的方法都添加事务；如果把这个注解添加方法上面，为这个方法添加事务。
// propagation 多事务方法直接进行调用，这个过程中事务是如何进行管理的
// isolation 事务隔离级别
// timeout 超时时间
// readOnly 是否只读
// rollbackFor 设置出现哪些异常进行事务回滚
// noRollbackFor 设置出现哪些异常不进行事务回滚
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,timeout = 3000)
public class AccountServerImpl implements AccountServer {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void transferAccount(Account fromAccount, Account toAccount, BigDecimal money) {
        accountDao.transferAccount(fromAccount, toAccount, money);
    }
}
