package com.hfm.getdata;

import com.hfm.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-23 15:08
 * @Description action 获取数据的原始方式
 * @date 2020/9/23
 */
public class OriginalWay extends ActionSupport {
    @Override
    public String execute(){
        // 通过 ServletActionContext 获取 HttpServletRequest 对象
        HttpServletRequest request = ServletActionContext.getRequest();

        // 获取参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        System.out.println(user);

        // 将数据放到 session 域中
        request.setAttribute("user", user);
        return SUCCESS;
    }
}
