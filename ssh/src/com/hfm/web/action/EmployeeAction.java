package com.hfm.web.action;

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

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private EmployeeServer employeeServer;

    @Autowired
    private DepartmentServer departmentServer;

    /**
     * 模型驱动自动注入前端参数
     */
    @Autowired
    private Employee employee;

    @Override
    public Employee getModel() {
        return employee;
    }

    /**
     * 添加员工
     *
     * @return
     */
    public String add() {
        if (employee.getId() != null) {
            return update();
        }

        // 获取部门 id
        String id = ServletActionContext.getRequest().getParameter("department.id");
        // 先查找部门
        Department department = departmentServer.findById(Integer.parseInt(id));

        String birth = ServletActionContext.getRequest().getParameter("birth");

        Date parse = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            parse = simpleDateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        employee.setBirth(parse);

        employee.setCreateTime(new Date());
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
     * 属性驱动获取前端参数
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 删除员工
     *
     * @return
     */
    public String delete() {
        employeeServer.delete(Integer.parseInt(id));
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

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 姓名是否存在
     *
     * @return
     */
    public String nameExited() throws IOException {
        boolean b = employeeServer.nameExited(employee.getLastName());
        if (b) {
            inputStream = new ByteArrayInputStream("0".getBytes(StandardCharsets.UTF_8));
        } else {
            inputStream = new ByteArrayInputStream("1".getBytes(StandardCharsets.UTF_8));
        }
        return "nameExited";
    }

    /**
     * 通过 id查询用户
     * @return
     */
    public String findById() {
        this.employee = employeeServer.findEmployeeById(Integer.parseInt(id));
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("employee", this.employee);
        List<Department> all = departmentServer.findAll();
        request.setAttribute("departments", all);
        request.setAttribute("departmentsSize", all.size());
        return "findById";
    }
}
