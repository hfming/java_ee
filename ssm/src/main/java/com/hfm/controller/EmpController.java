package com.hfm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hfm.domain.Dept;
import com.hfm.domain.Emp;
import com.hfm.service.DeptService;
import com.hfm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

/**
 * 前端控制器
 *
 * @author hfm
 * @since 2020-10-31
 */
@Controller
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    /**
     * 查询所有数据(分页)
     *
     * @return
     */
    @RequestMapping(path = "/emps")
    public @ResponseBody
    PageInfo<Emp> findAll(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "5") Integer pageSize) {
        if (currentPage == null || currentPage < 1) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 5;
        }
        // 使用分页插件
        com.github.pagehelper.Page<Emp> page = PageHelper.startPage(currentPage, pageSize);

        // 分页查询
        List<Emp> emps = empService.findAll(currentPage, pageSize);

        // 使用 pageInfo 包装
        PageInfo<Emp> pageInfo = new PageInfo<>(emps, 5);

        return pageInfo;
    }

    /**
     * 添加用户
     *
     * @param emp
     */
    @RequestMapping(path = "/emp", method = RequestMethod.POST)
    public @ResponseBody
    Integer add(@Valid Emp emp, Integer deptId, BindingResult bindingResult) {
        System.out.println("添加用户");
        // 查询 dept
        Dept dept = deptService.getOne(new QueryWrapper<Dept>().eq("dept_id", deptId));
        // 设置 dept
        emp.setDept(dept);
        // 添加 emp
        Integer empId = empService.saveEmp(emp);
        return empId;
    }

    /**
     * 通过id查询数据
     *
     * @param empId
     * @return
     */
    @RequestMapping(path = "/emp/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Emp findById(@PathVariable("id") Integer empId) {
        Emp emp = empService.getOne(new QueryWrapper<Emp>().eq("emp_id", empId));
        return emp;
    }


    /**
     * 校验员工名是否存在
     *
     * @param empName
     * @return
     */
    @RequestMapping(path = "/checkName")
    public @ResponseBody
    Boolean findByName(String empName) {
        int count = empService.count(new QueryWrapper<Emp>().eq("emp_name", empName));

        if (count == 0) {
            return false;
        }
        return true;
    }

    /**
     * 更新员工
     *
     * @param emp
     */
    @RequestMapping(path = "/emp/update")
    public @ResponseBody
    Boolean update(Emp emp, Integer deptId) {
        try {
            Dept dept = new Dept();
            dept.setDeptId(deptId);

            // 设置 dept
            emp.setDept(dept);
            empService.updateEmp(emp);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除数据
     *
     * @return
     */
    @RequestMapping(path = "/emp/{empId}", method = RequestMethod.DELETE)
    public @ResponseBody
    Boolean deleteById(@PathVariable("empId") Integer empId) {
        boolean b = empService.removeById(empId);
        return b;
    }

    /**
     * 通过 id 批量删除
     *
     * @param ins
     * @return
     */
    @RequestMapping(path = "/emp/batchdelete")
    public @ResponseBody
    Boolean batchDelete(@RequestBody List<Integer> ins) {
        boolean b = empService.removeByIds(ins);
        return b;
    }
}