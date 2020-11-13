package com.hfm.getdata;

import com.hfm.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-23 15:44
 * @Description action 获取数据的第三种方式 模型驱动
 * 通过定义模型成员成员,实现 ModelDriven 泛型接口,重写 getModel 方法,自动填充模型数据并返回模型
 * @date 2020/9/23
 */
public class ModelDrivenWay extends ActionSupport implements ModelDriven<User> {
    /**
     * 定义成员变量,模型驱动会自动填充数据
     */
    private User user = new User();

    /**
     * 返回模型,自动填充模型数据
     * @return
     */
    @Override
    public User getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(user);

        ServletActionContext.getRequest().setAttribute("user", user);

        return SUCCESS;
    }
}
