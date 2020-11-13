package com.hfm.getweb;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Arrays;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-17 20:57
 * @Description 通过实现 XXXAware 接口访问 web 资源
 * @date 2020/9/17
 */
public class AwareTest extends ActionSupport implements ApplicationAware, SessionAware, RequestAware, ParameterAware {
    public String test() {
        application.put("applicationTest", "Application");
        session.put("sessionTest", "Session");
        request.put("requestTest", "Request");

        // 获取参数
        for (Map.Entry<String, String[]> stringEntry : parameters.entrySet()) {
            System.out.println(stringEntry.getKey());
            // 值默认是数组结构
            System.out.println(Arrays.toString(stringEntry.getValue()));
        }
        // parameters 中存放数据
        parameters.put("name", parameters.get("name"));
        parameters.put("password", parameters.get("password"));

        // 清除 session 域中的数据
//        SessionMap sessionMap = (SessionMap) session;
//        sessionMap.invalidate();
        return "test";
    }

    private Map<String, Object> application;
    private Map<String, Object> session;
    private Map<String, Object> request;
    private Map<String, String[]> parameters;

    @Override
    public void setApplication(Map<String, Object> map) {
        this.application = map;
    }

    @Override
    public void setParameters(Map<String, String[]> map) {
        this.parameters = map;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
