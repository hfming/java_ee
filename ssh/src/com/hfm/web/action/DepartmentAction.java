package com.hfm.web.action;

import com.hfm.entity.Department;
import com.hfm.server.DepartmentServer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-04 19:03
 * @Description
 * @date 2020/10/4
 */
@Controller(value = "departmentAction")
@Scope(value = "prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
    /**
     * 模型驱动注入前端属性
     */
    private Department department;

    @Override
    public Department getModel() {
        return department;
    }

    @Autowired
    private DepartmentServer departmentServer;

    /**
     * 查找所有部门
     *
     * @return
     */
    public String findAll() {
        List<Department> departments = departmentServer.findAll();

        // 将数据存储到 request 域中
        ServletActionContext.getRequest().setAttribute("departments", departments);
        return "findAll";
    }

    /**
     * 通过名称查找部门
     *
     * @return
     */
    public String findByName() {
        String departmentName = department.getDepartmentName();

        Department departmentByName = departmentServer.findByName(departmentName);

        ServletActionContext.getRequest().setAttribute("department", departmentByName);

        return "findByName";
    }

    /**
     * 通过ID查询部门
     *
     * @return
     */
    public String findById() {
        Integer id = department.getId();
        Department departmentById = departmentServer.findById(id);

        ServletActionContext.getRequest().setAttribute("department", departmentById);

        return "findById";
    }
}
