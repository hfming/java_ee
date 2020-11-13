package com.hfm.getweb;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-17 21:40
 * @Description 通过 ServletActionContext 获取 web 资源,获取原生 Servlet API
 * @date 2020/9/17
 */
public class ServletActionContextTest extends ActionSupport {
    public String test(){
        // 使用 ServletActionContext 获取 ActionContext 对象
        ActionContext context = ServletActionContext.getContext();

        // 获取 ServletContext 对象
        ServletContext servletContext = ServletActionContext.getServletContext();
        // 将数据存储到 ServletContext 域中
        servletContext.setAttribute("applicationTest","Application");

        // 获取 HttpServletRequest 对象
        HttpServletRequest request = ServletActionContext.getRequest();
        // 获取表单参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.println(password);

        // 将数据存储到 request 域中
        request.setAttribute("requestTest","request");

        // 获取 session 对象
        HttpSession session = request.getSession();
        // 将数据存储到 session 域中
        session.setAttribute("sessionTest","Session");
        return "test";
    }
}
