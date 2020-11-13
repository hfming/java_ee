package com.hfm.interceptor;

import com.hfm.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-24 11:21
 * @Description
 * @date 2020/9/24
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> {
    /**
     * 登录功能
     *
     * @return
     */
    public String login() {
        // 查询数据库,用户名密码正确则可以登录
        if ("hfm".equalsIgnoreCase(user.getName()) && "17111711".equalsIgnoreCase(user.getPassword())) {
            HttpSession session = ServletActionContext.getRequest().getSession();

            // 将用户名存储到 session 域对象中
            session.setAttribute("username", user.getName());
            return "loginsuccess";
        }
        return "login";
    }

    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        return this.user;
    }
}
