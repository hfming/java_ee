package com.hfm.encapsulatedata;

import com.hfm.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-23 16:17
 * @Description 数据封装到 list 集合
 * @date 2020/9/23
 */
public class EList extends ActionSupport {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
