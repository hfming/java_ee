package com.hfm.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hfm.domain.Employee;
import com.hfm.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-29 20:02
 * @Description 条件构造器
 * @date 2020/10/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EntityWrapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    /**
     * 分页查询 selectPage
     */
    @Test
    public void selectPageTest() {
        // 创建分页对象
        Page<Employee> employeePage = new Page<>(2,2);

        // 创建条件对象
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("id", 6);

        employeePage = employeeMapper.selectPage(employeePage, queryWrapper);

        // 获取分页中的数据
        List<Employee> records = employeePage.getRecords();
        for (Employee record : records) {
            System.out.println(record);
        }
        // 获取当前页
        System.out.println(employeePage.getCurrent());
        // 获取每页记录数
        System.out.println(employeePage.getSize());
        // 获取中记录数
        System.out.println(employeePage.getTotal());
        // 获取总页数
        System.out.println(employeePage.getPages());
    }

    /**
     * selectOne 方法
     */
    public void selectOneTest() {
        // 通过构建查询条件对象进行查询
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("last_name", "tom");

        Employee employee = employeeMapper.selectOne(queryWrapper);
        System.out.println(employee);
    }

    /**
     * selectList 批量查询
     */
    @Test
    public void selectList() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", integers);

        List<Employee> employees = employeeMapper.selectList(queryWrapper);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


    /**
     * 通过 wrapper 条件对象进行删除
     */
    @Test
    public void  deleteWapper(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);

        employeeMapper.delete(wrapper);
    }
}
