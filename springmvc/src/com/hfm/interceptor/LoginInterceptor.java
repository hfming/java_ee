package com.hfm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-07 20:54
 * @Description
 * @date 2020/10/7
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果是登录页面则放行
        if (request.getRequestURI().indexOf("login.action") >= 0) {
            return true;
        }
        HttpSession session = request.getSession();
        //如果用户已登录也放行
        if (session.getAttribute("user") != null) {
            return true;
        }
        //用户没有登录挑战到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
