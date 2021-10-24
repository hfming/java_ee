package com.hfm.controller;

import com.hfm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-18 12:05
 * @Description
 * @date 2021/10/18
 */
@Controller(value = "restfulController")
@RequestMapping(path = "restful")
public class RestFulController {
    private static final String SUCCESS = "success";

    /**
     * 查询所有用户
     *
     * @param user
     * @return
     */
    @RequestMapping(path = "user", method = RequestMethod.GET)
    public String userList(User user) {
        System.out.println("查询所有用户");
        return SUCCESS;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping(path = "user", method = RequestMethod.POST)
    public String add(User user) {
        System.out.println("添加用户");
        return SUCCESS;
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @RequestMapping(path = "user", method = RequestMethod.PUT)
    public String update(User user) {
        System.out.println("修改用户" + user);
        return SUCCESS;
    }

    /**
     * 删除用户
     */
    @RequestMapping(path = "user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        System.out.println("删除用户" + id);
        return SUCCESS;
    }

    /**
     * 查询用户
     */
    @RequestMapping(path = "user/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable("id") Integer id) {
        System.out.println("查询一个用户" + id);
        return SUCCESS;
    }
}
