package com.hfm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-07 20:52
 * @Description
 * @date 2020/10/7
 */
@Controller(value = "userController")
@RequestMapping(path = "/user")
public class UserController {
    /**
     * 登陆页面
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(Model model) throws Exception {
        return "login";
    }


    /**
     * 登陆提交
     * userid：用户账号，pwd：密码
     *
     * @param session
     * @param userid
     * @param pwd
     * @return
     * @throws Exception
     */
    @RequestMapping("/loginsubmit")
    public String loginsubmit(HttpSession session, String userid, String pwd) throws Exception {
        //向session记录用户身份信息
        session.setAttribute("activeUser", userid);
        return "redirect:/main.jsp";
    }

    /**
     * 退出
     *
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        //session过期
        session.invalidate();
        return "redirect:index.jsp";
    }
}
