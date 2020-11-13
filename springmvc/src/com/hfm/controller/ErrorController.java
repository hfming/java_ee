package com.hfm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-07 19:41
 * @Description
 * @date 2020/10/7
 */
@RequestMapping(path = "/error")
@Controller(value = "errorController")
public class ErrorController {
    private final String SUCCESS = "success";

    @RequestMapping(path = "errorTest")
    public String errorTest() {
        int i = 10/0;
        return SUCCESS;
    }
}
