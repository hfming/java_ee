package com.hfm.getdata;

import com.hfm.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-12 14:32
 * @Description
 * @date 2021/10/12
 */
public class GetList extends ActionSupport  {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getList(){
        List<User> users = this.getUsers();
        System.out.println(users);
        return SUCCESS;
    }
}
