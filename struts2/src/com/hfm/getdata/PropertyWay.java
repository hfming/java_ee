package com.hfm.getdata;

import com.hfm.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-23 15:25
 * @Description action 获取数据的第二种方式 属性驱动
 * 通过定义成员属性以及属性的get set 方法,属性驱动会自动填充数据数据
 * @date 2020/9/23
 */
public class PropertyWay extends ActionSupport {
    /**
     * 数据自动封装到属性中
     */
    private String name;
    private String password;

    /**
     * 需要 get set 方法才能使用属性数据
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        User user = new User(name, password);

        System.out.println(user);

        // 将数据存储到 request 域中
        ServletActionContext.getRequest().setAttribute("user", user);
        return SUCCESS;
    }
}
