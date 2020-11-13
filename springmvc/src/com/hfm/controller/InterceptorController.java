package com.hfm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-07 20:11
 * @Description
 * @date 2020/10/7
 */
@Controller(value = "interceptorController")
@RequestMapping(path = "/interceptor")
public class InterceptorController {
    private final String SUCCESS = "success";

    @RequestMapping(path = "interceptorTest")
    private String interceptorTest(){
        System.out.println("controller 中的方法执行了");
        return SUCCESS;
    }
}
