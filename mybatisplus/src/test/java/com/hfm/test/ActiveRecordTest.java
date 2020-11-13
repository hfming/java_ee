package com.hfm.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hfm.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-29 20:42
 * @Description ActiveRecord 活动记录
 * @date 2020/10/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ActiveRecordTest {
    @Autowired
    private Employee employee;

    /**
     * 插入操作
     */
    @Test
    public void arInsertTest() {
        employee.setLastName("hfm");
        employee.setAge(25);
        employee.setEmail("hfming.com");

        // 继承 model ，model 有很多CRUD 方法，Empoyee 自身具有 CRUD 方法
        boolean insert = employee.insert();
        // 是否插入成功
        System.out.println(insert);
    }

    /**
     * 修改操作
     */
    @Test
    public void updateTest(){
        Employee employee = this.employee.selectById(1);

        employee.setLastName("new");

        // 通过 ID修改
        boolean b = employee.updateById();
        System.out.println(b);

        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", 1);
        // 通过条件构造器更新数据
        boolean update = employee.update(wrapper);
        // 是否更新成功
        System.out.println(update);
    }

    /**
     * 查询操作
     */
    @Test
    public void  selectTest(){
        // 1.通过 Id 查询
        Employee employee = this.employee.selectById(1);
        System.out.println(employee);

        // 构建条件对象
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1);

        // 2.通过条件对象进行查询单条数据
        Employee employee1 = employee.selectOne(queryWrapper);
        System.out.println(employee1);

        // 3.查询所有数据
        List<Employee> employees = employee.selectAll();
        for (Employee employee2 : employees) {
            System.out.println(employee2);
        }

        // 4.selectList 通过条件对象查询集合
        List<Employee> employeeList = employee.selectList(new QueryWrapper<Employee>().lt("id", 4));
        for (Employee employee2 : employeeList) {
            System.out.println(employee2);
        }

        // 5.查询数值
        Integer count = employee.selectCount(new QueryWrapper<Employee>().lt("id", 5));
        System.out.println(count);

        // 6.分页查询
        Page<Employee> page = employee.selectPage(new Page<Employee>(1, 3), new QueryWrapper<Employee>().lt("id", 5));
    }

    /**
     * 删除操作
     */
    @Test
    public void  deleteTest(){
        employee.deleteById();

        // 通过 id 删除
        boolean b = employee.deleteById(1);
        System.out.println(b);

        // 通过条件对象进行删除
        boolean id = employee.delete(new QueryWrapper<Employee>().lt("id", 5));
    }
}
