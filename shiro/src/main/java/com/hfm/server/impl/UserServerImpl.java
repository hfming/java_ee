package com.hfm.server.impl;

import com.hfm.dao.UserDao;
import com.hfm.domain.User;
import com.hfm.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-19 11:09
 * @Description
 * @date 2020/10/19
 */
@Service(value = "userServer")
public class UserServerImpl implements UserServer {
    @Autowired
    private UserDao userDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User login(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username, password);
    }
}
