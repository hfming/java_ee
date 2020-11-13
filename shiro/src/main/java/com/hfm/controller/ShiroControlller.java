package com.hfm.controller;

import com.hfm.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-19 11:03
 * @Description
 * @date 2020/10/19
 */
@Controller(value = "shiroController")
@RequestMapping(path = "/shiro")
public class ShiroControlller {
    private static final String SUCCESS = "success";

    /**
     * 登录功能
     *
     * @return
     */
    @RequestMapping(path = "login")
    public String login(User user) {
        // 1.获取当前的 subject
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            // rememberme
            token.setRememberMe(true);
            try {
                // 执行登录
                currentUser.login(token);
                return SUCCESS;
            }
            // 这里捕获更多异常(可能是特定于您的应用程序的自定义异常?
            // 所有认证时异常的父类.
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
                System.out.println("登录失败" + ae.getMessage());
            }
        }
        return "redirect:/login.jsp";
    }
}
