package com.hfm.getdata;

import com.hfm.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-23 16:02
 * @Description action 获取数据的第三种方式 表达式封装
 * @date 2020/9/23
 */
public class ExpressionWay extends ActionSupport {
    /**
     * 声明实体类对象
     */
    private User user;

    /**
     * 需要 set 与 get 方法自动进行数据封装
     * @return
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(user);

        ServletActionContext.getRequest().setAttribute("user", user);
        return SUCCESS;
    }
}
