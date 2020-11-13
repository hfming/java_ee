package com.hfm.dao;

import com.hfm.domain.Account;
import com.hfm.domain.subject.AccountSubject;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-23 16:36
 * @Description
 * @date 2020/10/23
 */
public interface AccountDao3 {
    /**
     * 第一种方式实现一对多操作
     * 查询所有账户，同时获取账户的所属用户名称以及它的地址信息
     *
     * @return
     */
    List<AccountSubject> findAll();

    /**
     * 第二种方式实现一对多操作
     *
     * @return
     */
    List<Account> findAll2();

    /**
     * 延迟加载
     *
     * @return
     */
    List<Account> lazyFind();
}
