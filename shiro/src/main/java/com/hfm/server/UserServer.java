package com.hfm.server;


import com.hfm.domain.User;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-19 11:09
 * @Description
 * @date 2020/10/19
 */
public interface UserServer {
    User login(String username, String password);
}
