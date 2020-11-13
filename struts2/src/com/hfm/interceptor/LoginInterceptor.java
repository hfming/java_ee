package com.hfm.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-23 21:34
 * @Description 通过继承 MethodFilterInterceptor 自定义拦截器
 * @date 2020/9/23
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();

        String username = (String) session.getAttribute("username");

        // 判断session 中是否有用户名
        if (username == null || "".equalsIgnoreCase(username.trim()) || "null".equalsIgnoreCase(username.trim())) {
            return "login";
        }

        // 正常调用方法
        return actionInvocation.invoke();
    }
}
