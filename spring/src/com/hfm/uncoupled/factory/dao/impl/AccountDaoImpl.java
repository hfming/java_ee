package com.hfm.uncoupled.factory.dao.impl;

import com.hfm.uncoupled.factory.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
