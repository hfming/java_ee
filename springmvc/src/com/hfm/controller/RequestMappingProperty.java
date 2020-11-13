package com.hfm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-05 18:22
 * @Description @RequestMapping 属性测试
 * @date 2020/10/5
 */
@Controller
@RequestMapping(path = "/propertyTest")
public class RequestMappingProperty {
    private final String SUCCESS = "success";

    /**
     * method 属性用于设置请求方式，请求方式不相同不能访问
     * 可以接收多种请求方式,用 {}括起来，用逗号隔开
     *
     * @return
     */
    @RequestMapping(path = "psot", method = {RequestMethod.POST, RequestMethod.GET})
    public String methodPost() {
        System.out.println("post 请求");
        return SUCCESS;
    }

    @RequestMapping(path = "get", method = RequestMethod.GET)
    public String methodGet() {
        System.out.println("get 请求");
        return SUCCESS;
    }

    /**
     * params 属性用于指定限制请求参数的条件。它支持简单的表达式。要求请求参数的key和value必须和配置的一模一样。
     *
     * @return
     */
    @RequestMapping(path = "params", method = {RequestMethod.POST, RequestMethod.GET}, params = {"name", "money=100"})
    public String params() {
        System.out.println("params 属性");
        return SUCCESS;
    }

    /**
     * headers 属性用于指定限制请求消息头的条件。发送的请求中必须包含的请求头
     *
     * @return
     */
    @RequestMapping(path = "headers", headers = {"Referer"},method = {RequestMethod.POST,RequestMethod.GET})
    public String headers() {
        System.out.println("headers 属性");
        return SUCCESS;
    }
}
