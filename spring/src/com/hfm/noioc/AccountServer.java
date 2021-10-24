package com.hfm.noioc;

import java.math.BigDecimal;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-30 11:17
 * @Description
 * @date 2020/9/30
 */
public interface AccountServer {
    /**
     * 转账
     * @param fromAccount
     * @param toAccount
     * @param money
     */
    void transferAccount(Account fromAccount, Account toAccount, BigDecimal money);
}
