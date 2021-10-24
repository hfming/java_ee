package com.hfm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-05 15:54
 * @Description 控制器类
 * @date 2020/10/5
 */
/**
 * web 层 bean 注解，会保存到 IOC 中
 */
@Controller(value = "firstController")
public class FirstController {
    public FirstController() {
        System.out.println("创建");
    }

    /**
     * 配置映射路径(访问的url)
     *
     * @return
     */
    @RequestMapping(path = "/hello")
    public String helloSpringMvc() {
        System.out.println("hello spring mvc");
        return "success";
    }
}
