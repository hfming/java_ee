package com.hfm.controller;

import com.hfm.pojo.ListParam;
import com.hfm.pojo.ObjectParam;
import com.hfm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-05 20:13
 * @Description 请求参数的绑定
 * @date 2020/10/5
 */
@Controller(value = "paramsController")
@RequestMapping(path = "/params")
public class ParamsController {
    private final String SUCCESS = "success";

    /**
     * 请求参数的绑定，在参数输入列表中定义参数
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(path = "paramsTest", params = {"username", "password"})
    public String paramsTest(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return SUCCESS;
    }

    /**
     * 基本数据类型参数绑定
     *
     * @param username
     * @param number
     * @param flag
     * @return
     */
    @RequestMapping(path = "paramsBase", params = {"username", "number", "flag", "character", "adouble"})
    public String paramsBase(String username, Integer number, Boolean flag, Character character, Double adouble) {
        System.out.println(username);
        System.out.println(number);
        System.out.println(flag);
        System.out.println(character.charValue());
        System.out.println(adouble.doubleValue());
        return SUCCESS;
    }

    /**
     * 对象数据类型
     *
     * @param user
     * @return
     */
    @RequestMapping(path = "paramsObject", params = {"username", "password"})
    public String paramsObject(User user) {
        System.out.println(user);
        return SUCCESS;
    }

    /**
     * 数组数据类型
     * @param hobbys
     * @return
     */
    @RequestMapping(path = "paramsArray")
    public String paramsArray(String[] hobbys) {
        System.out.println(Arrays.toString(hobbys));
        return SUCCESS;
    }

    /**
     * 对象数据类型中的对象类型属性
     *
     * @param objectParam
     * @return
     */
    @RequestMapping(path = "paramsObjectProp")
    public String paramsObjectProp(ObjectParam objectParam) {
        System.out.println(objectParam);
        return SUCCESS;
    }

    /**
     * 对象类型中有集合类型属性
     *
     * @param listParam
     * @return
     */
    @RequestMapping(path = "paramsListProp")
    public String paramsListProp(ListParam listParam) {
        // String 数组
        System.out.println(Arrays.toString(listParam.getStrings()));
        // 对象数组
        System.out.println(Arrays.toString(listParam.getUsers()));
        // String list
        System.out.println(listParam.getStringList());
        // 对象 list
        System.out.println(listParam.getUserList());
        // String map
        for (Map.Entry<Integer, String> entry : listParam.getStringMap().entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        // 对象 Map
        for (Map.Entry<Integer, User> entry : listParam.getUserMap().entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }

        return SUCCESS;
    }

    /**
     * 自定义数据类型转换器
     * @return
     */
    @RequestMapping(path = "paramsDate")
    public String paramsDate(Date date) {
        System.out.println(date);
        return SUCCESS;
    }

    /**
     * 获取原生 Servlet API
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(path = "parmasServletAPI")
    public String parmasServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        System.out.println(response);
        return SUCCESS;
    }
}
