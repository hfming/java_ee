package com.hfm.getweb;

import com.hfm.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-18 10:16
 * @Description Web 资源访问案例
 * @date 2020/9/18
 */
public class UserAction extends ActionSupport implements SessionAware, ParameterAware, ApplicationAware {
    private Map<String, Object> session;
    private Map<String, String[]> parameters;
    private Map<String, Object> application;

    /**
     * struts2 注入
     *
     * @param map
     */
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void setParameters(Map<String, String[]> map) {
        this.parameters = map;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        application = map;
    }

    /**
     * 登录功能
     *
     * @return
     */
    public String login() {
        // 获取 application 域中的数据
        Integer num = (Integer) application.get("num");

        User user = new User();
        // 获取参数
        user.setName(parameters.get("name")[0]);
        user.setPassword(parameters.get("password")[0]);

        // 放入 session 域中
        session.put("name", user.getName());

        if (num == null) {
            application.put("num", 1);
        } else {
            application.put("num", num + 1);
        }
        return "login";
    }

    /**
     * 退出功能
     *
     * @return
     */
    public String logout() {
        Integer num = (Integer) application.get("num");

        // 从 session 域中删除
        session.remove("name");

        // 删除 session 中所有数据
        // 先转发为 SessionMap
        SessionMap sessionMap = (SessionMap) this.session;
        // 调用 invalidate 方法删除所有 session 域中所有数据
        sessionMap.invalidate();

        if (num == null) {
            application.put("num", 0);
        } else {
            application.put("num", num - 1);
        }
        return "logout";
    }
}
