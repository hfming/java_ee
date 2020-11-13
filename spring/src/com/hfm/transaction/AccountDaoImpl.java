package com.hfm.transaction;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-30 11:17
 * @Description
 * @date 2020/9/30
 */
@Repository(value = "accountDaoImpl")
public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {
    /**
     * 转账业务
     * @param fromAccount
     * @param toAccount
     * @param money
     */
    @Override
    public void transferAccount(Account fromAccount, Account toAccount, BigDecimal money) {
        String sql = "update  tab_account set balance = ? where accountId = ?";
        // fromAccount 转出
        change(sql, fromAccount.getBalance().subtract(money), fromAccount.getAccountId());
        // toAccount 转入
        change(sql, toAccount.getBalance().add(money), toAccount.getAccountId());
    }
}
