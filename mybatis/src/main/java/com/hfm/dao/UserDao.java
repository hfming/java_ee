package com.hfm.dao;

import com.hfm.domain.User;
import com.hfm.domain.condition.UserCondition;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-21 16:02
 * @Description
 * @date 2020/10/21
 */
public interface UserDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<User> findAll();

    /**
     * 通过 Id 查询
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 保存用户
     *
     * @param user
     */
    void save(User user);

    /**
     * 修改用户
     *
     * @param user
     */
    void update(User user);

    /**
     * 模糊查询
     *
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 统计记录数目
     *
     * @return
     */
    Long count();

    /**
     * 通过 id 删除用户
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 动态查询,根据传入的条件进行查询
     *
     * @param user
     * @return
     */
    List<User> findByUser(User user);

    /**
     * where 标签动态查询
     *
     * @param user
     * @return
     */
    List<User> findByCondition(User user);

    /**
     * foreach 标签动态查询
     *
     * @param userCondition
     * @return
     */
    List<User> findByIntegers(UserCondition userCondition);

}
