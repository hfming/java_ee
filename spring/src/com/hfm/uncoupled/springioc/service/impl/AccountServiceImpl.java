package com.hfm.uncoupled.springioc.service.impl;

import com.hfm.uncoupled.springioc.dao.IAccountDao;
import com.hfm.uncoupled.springioc.dao.impl.AccountDaoImpl;
import com.hfm.uncoupled.springioc.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao ;

    /**
     * 构造函数
     */
    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    @Override
    public void  saveAccount(){
        accountDao.saveAccount();
    }

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }
}
