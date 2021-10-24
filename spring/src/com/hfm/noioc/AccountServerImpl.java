package com.hfm.noioc;

import java.math.BigDecimal;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-30 11:18
 * @Description
 * @date 2020/9/30
 */

public class AccountServerImpl implements AccountServer {
    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transferAccount(Account fromAccount, Account toAccount, BigDecimal money) {
        TransactionManager transactionManager = new TransactionManager();

        transactionManager.beginTransaction();
        try {
            /**
             * 模拟转账出现问题
             */
//            int i= 10/0;
            accountDao.transferAccount(fromAccount, toAccount, money);
            System.out.println("正常提交");
            // 没有出现就提交
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 出现异常就回滚
            System.out.println("出现异常！");
            transactionManager.rollback();
        }
    }
}
