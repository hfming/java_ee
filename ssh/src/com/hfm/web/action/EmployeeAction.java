package com.hfm.web.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hfm.entity.Department;
import com.hfm.entity.Employee;
import com.hfm.server.DepartmentServer;
import com.hfm.server.EmployeeServer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-04 17:19
 * @Description
 * @date 2020/10/4
 */
@Controller(value = "employeeAction")
@Scope(value = "prototype")
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
    /**
     * 模型驱动自动注入前端参数
     */
    private Employee employee;

    @Override
    public Employee getModel() {
        return employee;
    }

    private String departmentName;

    @Autowired
    private EmployeeServer employeeServer;

    @Autowired
    private DepartmentServer departmentServer;

    /**
     * 添加员工
     *
     * @return
     */
    public String add() {
        // 先查找部门
        Department department = departmentServer.findByName(departmentName);
        // 设置员工所在部门
        employee.setDepartment(department);
        // 添加员工
        employeeServer.add(employee);
        return "add";
    }

    /**
     * 修改员工
     *
     * @return
     */
    public String update() {
        employeeServer.update(employee);
        return "update";
    }

    /**
     * 删除员工
     *
     * @return
     */
    public String delete() {
        employeeServer.delete(employee.getId());
        return "delete";
    }

    /**
     * 查找所有员工
     *
     * @return
     */
    public String findAll() {
        List<Employee> employees = employeeServer.findAll();

        ServletActionContext.getRequest().setAttribute("employees", employees);
        return "findAll";
    }

    /**
     * 姓名是否存在
     *
     * @return
     */
    public String nameExited() throws IOException {
        boolean b = employeeServer.nameExited(employee.getLastName());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        if (b == true) {
            json = objectMapper.writeValueAsString(true);
        } else {
            json = objectMapper.writeValueAsString(false);
        }
        ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
        objectMapper.writeValue(outputStream, json);
        return "nameExited";
    }
}
