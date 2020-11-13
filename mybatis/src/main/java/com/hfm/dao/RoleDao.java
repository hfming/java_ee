package com.hfm.dao;

import com.hfm.domain.Role;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-23 19:51
 * @Description
 * @date 2020/10/23
 */
public interface RoleDao {
    /**
     * 查询所有
     * @return
     */
    List<Role> findAll();

    /**
     * 通过 id 查询
     * @param id
     * @return
     */
    Role findById(Integer id);

    /**
     * 多对多延迟加载
     * @return
     */
    List<Role> lazyFind();
}
