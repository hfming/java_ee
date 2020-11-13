package com.hfm.controller;

import com.hfm.domain.Department;
import com.hfm.domain.Employee;
import com.hfm.server.DepartmentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-17 9:54
 * @Description
 * @date 2020/10/17
 */
@Controller(value = "departmentController")
@RequestMapping(path = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentServer departmentServer;

    @RequestMapping(method = RequestMethod.GET, path = "list")
    public ModelAndView getAllDepartment(HttpServletRequest request) {
        // 创建模型及视图
        ModelAndView modelAndView = new ModelAndView();

        // 设置视图
        modelAndView.setViewName("emp/input");

        Employee employee = (Employee) request.getAttribute("employee");
        List<Department> departments = departmentServer.findAll();
        // 添加数据
        modelAndView.addObject("departments", departments);
        modelAndView.addObject("employee", employee);

        // 转发到视图
        return modelAndView;
    }
}
