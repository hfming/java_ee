package com.hfm.dao;

import com.hfm.domain.User;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-23 16:21
 * @Description
 * @date 2020/10/23
 */
public interface UserDao3 {
    /**
     * 查询所有
     *
     * @return
     */
    List<User> findAll();

    /**
     * 通过 id 查找
     * @param id
     * @return
     */
    User findById(Integer id);
}
