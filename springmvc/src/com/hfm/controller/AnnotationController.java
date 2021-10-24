package com.hfm.controller;

import com.hfm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-06 12:18
 * @Description
 * @date 2020/10/6
 */
@Controller(value = "annotationController")
@RequestMapping(path = "/annotation")
/**
 * @SessionAttributesz 注解 用于多次执行控制器方法间的参数共享。
 * value 属性用于指定存入的属性名称
 * type 属性用于指定存入的数据类型。
 */
@SessionAttributes(value = {"username", "password", "age"}, types = {String.class, Integer.class})
public class AnnotationController {
    private final String SUCCESS = "success";

    /**
     * @param username
     * @param password
     * @return
     * @RequestParam 注解的作用：前端的参数名与控制器中的形参名不一样时，可以使用 @RequestParam 注解，将前端的参数赋值给指定的形参。
     * value 属性：请求参数中的名称
     * required 属性：请求参数中是否必须提供此参数。默认值：true。表示必须提供，如果不提供将报错。
     */
    @RequestMapping(path = "requestParamTest")
    public String requestParamTest(@RequestParam(value = "name", required = true) String username, @RequestParam(value = "ps") String password) {
        System.out.println(username);
        System.out.println(password);
        return SUCCESS;
    }

    /**
     * @param body
     * @return
     * @RequestBody 注解的作用
     */
    @RequestMapping(path = "requestBodyTest")
    public String requestBodyTest(@RequestBody(required = false) String body) {
        System.out.println(body);
        return SUCCESS;
    }

    /**
     * @param id
     * @return
     * @PathVariable 注解用于绑定url中的占位符。
     * value 属性 用于指定url中占位符名称。
     * required 属性 是否必须提供占位符。
     * GET 用来获取资源，POST 用来新建资源，PUT 用来更新资源，DELETE 用来删除资源。
     */
    @RequestMapping(path = "pathVariableTest/{id}", method = RequestMethod.GET)
    public String pathVariableTest1(@PathVariable(value = "id") Integer id) {
        System.out.println("GET 方法");
        return SUCCESS;
    }

    @RequestMapping(path = "pathVariableTest/{id}", method = RequestMethod.POST)
    public String pathVariableTest2(@PathVariable(value = "id") Integer id) {
        System.out.println("POST 方法");
        return SUCCESS;
    }

    /**
     * @param header
     * @return
     * @RequestHeader 注解的作用用于获取请求消息头
     * value 属性获取的请求头名称
     */
    @RequestMapping(path = "requestHeaderTest", headers = "Accept")
    public String requestHeaderTest(@RequestHeader(value = "Accept") String header) {
        System.out.println(header);
        return SUCCESS;
    }

    /**
     * @param cookieValue
     * @return
     * @CookieValue 注解用于获取指定cookie的名称的值。
     * value 属性指定cookie的名称
     * required 属性是否是必须的
     */
    @RequestMapping(path = "cookieValueTest")
    public String cookieValueTest(@CookieValue(value = "JSESSIONID", required = false) String cookieValue) {
        System.out.println(cookieValue);
        return SUCCESS;
    }

    /**
     * @ModelAttribute 注解方法有返回值
     * @ModelAttribute 注解方法表示当前方法会在控制器的方法执行之前，先执行。
     */
    @ModelAttribute
    public User modelAttribute() {
        System.out.println("当前方法会在控制器的方法执行之前，先执行。1");
        User hfm = new User(1, "hfm", "17111711");
        System.out.println(hfm);
        return hfm;
    }

    /**
     * @param user
     * @return
     * @ModelAttribute 注解属性作用获取指定的数据给参数赋值。
     */
    @RequestMapping(path = "modelAttributeTest")
    public String modelAttributeTest(@ModelAttribute(value = "user") User user) {
        System.out.println("控制器的方法执行");
        System.out.println(user);
        return SUCCESS;
    }

    /**
     * @param map
     * @ModelAttribute 注解方法没有返回值, 需要与 @ModelAttribute 注解注解属性一起使用
     */
    @ModelAttribute
    public void modelAttribute(Map<String, User> map) {
        System.out.println("当前方法会在控制器的方法执行之前，先执行。2");
        User hfm = new User(1, "hfm", "17111711");
        System.out.println(hfm);
        map.put("user", hfm);
    }

    /**
     * 向session中存入值
     * Model是spring提供的一个接口，该接口有一个实现类 ExtendedModelMap 该类继承了ModelMap，而ModelMap就是LinkedHashMap子类
     *
     * @return
     */
    @RequestMapping(path = "sessionAttributePutTest")
    public String sessionAttributePutTest(Model model) {
        System.out.println("向session域中保存数据");
        model.addAttribute("username", "root");
        model.addAttribute("password", "123");
        System.out.println("root:123");
        //跳转之前将数据保存到username、password和age中，因为注解@SessionAttribute中有这几个参数

        return SUCCESS;
    }

    /**
     * 从session中获取值
     * ModelMap就是LinkedHashMap子类，用于存储 Session 键值对
     *
     * @return
     */
    @RequestMapping(path = "sessionAttributeGetTest")
    public String sessionAttributeGetTest(ModelMap modelMap) {
        System.out.println("取出 session 中的数据");
        String username = (String) modelMap.get("username");
        String password = (String) modelMap.get("password");
        System.out.println(username + " : " + password);
        return SUCCESS;
    }

    /**
     * 清除值
     *
     * @return
     */
    @RequestMapping(path = "sessionAttributeCleanTest")
    public String sessionAttributeCleanTest(SessionStatus status) {
        System.out.println("清空 session 域");
        status.setComplete();
        return SUCCESS;
    }
}
