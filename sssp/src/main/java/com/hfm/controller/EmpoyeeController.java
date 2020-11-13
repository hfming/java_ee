package com.hfm.controller;

import com.hfm.domain.Employee;
import com.hfm.server.EmployeeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-16 18:52
 * @Description
 * @date 2020/10/16
 */
@Controller(value = "employeeController")
public class EmpoyeeController {
    @Autowired
    private EmployeeServer employeeServer;

    /**
     * 分页查询所有
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(path = "/employees")
    public ModelAndView getAll(@RequestParam(required = false) Integer pageNo, @RequestParam(required = false) Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        if (pageSize == null || pageSize < 1) {
            pageSize = 5;
        }
        if (pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        Page<Employee> page = employeeServer.getPage(pageNo, pageSize);

        modelAndView.addObject("page", page);
        modelAndView.setViewName("emp/list");
        return modelAndView;
    }

    /**
     * 通过名称查询
     *
     * @return
     */
    @RequestMapping(path = "/nameExited")
    public @ResponseBody
    Boolean findByName(@RequestParam(required = true) String lastName) {
        System.out.println(lastName);
        return employeeServer.nameIsExited(lastName);
    }

    /**
     * 通过id查询
     *
     * @return
     */
    @RequestMapping(path = "/employee")
    public void findbById(Integer id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(id);
        // 通过 id 查找对象
        Employee employee = employeeServer.findById(id);

        request.setAttribute("employee", employee);

        request.getRequestDispatcher("department/list").forward(request, response);
    }

    /**
     * 添加与修改功能
     *
     * @return
     */
    @RequestMapping(path = "/employee/saveAndUpdate")
    public void add(Employee employee, HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println(employee);
        // 添加
        employeeServer.saveAndUpdate(employee);

        response.sendRedirect(request.getContextPath() + "/employees");
    }

    /**
     * 删除功能
     *
     * @return
     */
    @RequestMapping(path = "/employee/delete")
    public void delete(Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println(id);
        // 根据 id 删除
        employeeServer.delete(id);
        response.sendRedirect(request.getContextPath() + "/employees");
    }
}
