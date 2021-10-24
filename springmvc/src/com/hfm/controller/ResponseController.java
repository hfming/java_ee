package com.hfm.controller;

import com.hfm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-06 19:02
 * @Description
 * @date 2020/10/6
 */
@RequestMapping(path = "/response")
@Controller(value = "responseController")
public class ResponseController {
    private final String SUCCESS = "success";

    /**
     * controller方法返回字符串可以指定逻辑视图名，通过视图解析器解析为物理视图地址。
     * 指定逻辑视图名，经过视图解析器解析为jsp物理路径：/WEB-INF/pages/success.jsp
     *
     * @return
     */
    @RequestMapping(path = "stringTest")
    public String stringTest(User user, Model model) {
        System.out.println("响应数据类型为 String 型");
        // 放入 request 域与 session 域中
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());

        return SUCCESS;
    }

    /**
     * 如果控制器的方法返回值编写成void，执行程序报404的异常，默认查找JSP页面没有找到。默认会跳转到@RequestMapping(value="/initUpdate") initUpdate的页面。
     * 可以使用请求转发或者重定向跳转到指定的页面
     * 请求转发
     */
    @RequestMapping(path = "voidTest1")
    public void voidTest1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("响应数据类型为 void 无返回值 请求转发");

        // 请求转发
        request.getRequestDispatcher("/response/stringTest").forward(request, response);
    }

    /**
     * 重定向
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(path = "voidTest2")
    public void voidTest2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("响应数据类型为 void 无返回值 重定向");

        // 或者重定向
        response.sendRedirect(request.getContextPath() + "/response/stringTest");
    }

    /**
     * 直接返回指定类型的数据
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(path = "voidTest3")
    public void voidTest3(HttpServletResponse response) throws IOException {
        System.out.println("响应数据类型为 void 无返回值 重定向");

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        // 直接输出 json 数据
        response.getWriter().write("json 串");
//        文本类型
//        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().print("你好");
    }

    /**
     * ModelAndView对象是Spring提供的一个对象，可以用来调整具体的JSP视图。
     *
     * @return ModelAndView
     */
    @RequestMapping(path = "modelAndViewTest")
    public ModelAndView modelAndViewTest(User user) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", user.getUsername());
        mv.addObject("password", user.getPassword());
        // 视图解析器
        mv.setViewName("model");
        return mv;
    }

    /**
     * SpringMVC 提供的请求转发关键字 forward 的使用
     *
     * @return
     */
    @RequestMapping(path = "forwardTest")
    public String forwardTest() {

        return "forward:/WEB-INF/pages/success.jsp";
    }

    /**
     * SpringMVC 提供的请求转发关键字 redirect 的使用
     *
     * @return
     */
    @RequestMapping(path = "redirectTest")
    public String redirectTest() {

        // 重定向到控制器的其他方法，如果是重定向到jsp页面，则jsp页面不能写在WEB-INF目录中，否则无法找到。
        return "redirect:stringTest";
    }

    /**
     * @param json
     * @RequestBody 注解 用于获取请求体的内容（注意：get方法不可以，get 请求没有请求体，而是将参数放到地址栏中）。
     * 直接使用得到是key=value&key=value...结构的数据。
     * Ajax 的post 请求将数据放在请求体中需要使用 @RequestBody 注解才能访问
     */
    @RequestMapping(path = "ajaxTest")
    public void ajaxTest(@RequestBody String json) {
        // 打印 json 数据
        System.out.println(json);
    }

    /**
     * json 字符串转对象
     *
     * @param user
     */
    @RequestMapping(path = "jsonToObject")
    // @ResponseBody
    public @ResponseBody User jsonToObject(@RequestBody User  user) {
        System.out.println(user);

        return user;
    }


    /**
     * 接收 integer 数组
     * @param ins
     */
    @RequestMapping(path = "arrayInteger")
    public void arrayInteger(@RequestBody Integer[] ins) {
        System.out.println("接收 integer 数组");
        for (Integer in : ins) {
            System.out.println(in);
        }
    }

    /**
     * 接收 integer list 集合
     * @param ins
     */
    @RequestMapping(path = "listInteger")
    public void listInteger(@RequestBody List<Integer> ins) {
        System.out.println("接收 integer list 集合");
        for (Integer in : ins) {
            System.out.println(in);
        }
    }

    /**
     * 接收 String 数组
     * @param strings
     */
    @RequestMapping(path = "arrayString")
    public void arrayString(@RequestBody String[] strings) {
        System.out.println("接收 String 数组");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * 接收 String list 集合
     * @param strings
     */
    @RequestMapping(path = "listString")
    public void listString(@RequestBody List<String> strings) {
        System.out.println("接收 String list 集合");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * 接收 Object 数组
     * @param users
     */
    @RequestMapping(path = "arrayObject")
    public void arrayObject(@RequestBody User[] users) {
        System.out.println("接收 Object 数组");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 接收 Object 集合
     * @param users
     */
    @RequestMapping(path = "listObject")
    public void listObject(@RequestBody List<User> users) {
        System.out.println("接收 Object 集合");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 接收 Map<String, User>
     * @param map
     */
    @RequestMapping(path = "mapObject")
    public void mapString(@RequestBody Map<String, User> map) {
        System.out.println("接收 Map<String, User> 集合");
        for (Map.Entry<String, User> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }
    }

}
