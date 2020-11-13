package com.hfm.dao;

import com.hfm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-19 11:08
 * @Description
 * @date 2020/10/19
 */
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    /**
     * 通过姓名与密码查找用户
     *
     * @param username
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);
}
