package com.hfm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-05 17:56
 * @Description 模块化开发 springmvc
 * @date 2020/10/5
 */
@Controller(value = "modelController")
/**
 * @RequestMapping 在类上表示一级路径
 * 目的是为了使我们的URL可以按照模块化管理
 */
@RequestMapping(path = "/account")
public class ModelController {
    /**
     * @return
     * @RequestMapping 在方法上表示二级路径
     */
    @RequestMapping(path = "add")
    public String add() {
        System.out.println("add");
        return "success";
    }

    @RequestMapping(path = "delete")
    public String delete() {
        System.out.println("delete");
        return "success";
    }
}
