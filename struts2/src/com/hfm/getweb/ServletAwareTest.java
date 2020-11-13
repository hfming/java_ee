package com.hfm.getweb;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-17 21:43
 * @Description 通过 实现 ServletXXXAware 方法访问 web 资源
 * @date 2020/9/17
 */
public class ServletAwareTest extends ActionSupport implements ServletContextAware, ServletRequestAware, ServletResponseAware {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext servletContext;

    public String test() {
        // 将数据存储到 ServletContext 域中
        servletContext.setAttribute("applicationTest","Application");

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

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
