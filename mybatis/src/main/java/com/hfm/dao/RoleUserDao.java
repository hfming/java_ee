package com.hfm.dao;

import com.hfm.domain.RoleUser;
import com.hfm.domain.User;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-23 16:21
 * @Description
 * @date 2020/10/23
 */
public interface RoleUserDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<RoleUser> findAll();

    /**
     * 通过 id 查询
     *
     * @param id
     * @return
     */
    RoleUser findById(Integer id);

    /**
     * 多对多延迟加载
     *
     * @return
     */
    List<RoleUser> lazyFind();
}
