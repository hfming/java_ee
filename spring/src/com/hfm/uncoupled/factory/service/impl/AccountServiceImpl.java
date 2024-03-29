package com.hfm.uncoupled.factory.service.impl;

import com.hfm.uncoupled.factory.beanfactory.BeanFactory;
import com.hfm.uncoupled.factory.dao.IAccountDao;
import com.hfm.uncoupled.factory.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    //    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
