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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-26 21:56
 * @Description
 * @date 2020/10/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmployeeDaoTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void selectListTest() {
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);
    }

    /**
     * insert 方法
     */
    @Test
    public void insertTest() {
        Employee employee = new Employee();
        employee.setLastName("hfm");
        employee.setEmail("hfming2016@163.com");
        employee.setAge(26);
        employee.setGender(1);

        // 插入数据，返回影响条数
        int insert = employeeMapper.insert(employee);
        System.out.println(insert);

        // 插入后可以获取主键的值
        System.out.println(employee.getId());
    }

    /**
     * 更新操作
     */
    @Test
    public void updateTest() {
        Employee employee = employeeMapper.selectById(1);
        employee.setLastName("new");

        // 通过 id 更新
        employeeMapper.updateById(employee);
    }

    /**
     * 通过 id 查询
     */
    @Test
    public void selectTest() {
        // 通过 id 查询数据
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);
    }

    /**
     * selectOne 方法
     */
    @Test
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
     * selectByMap 方法
     */
    @Test
    public void selectMapTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);

        // 传入 map 对象
        List<Employee> employees = employeeMapper.selectByMap(map);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * selectMaps 将查询到的字段封装成 map 数据
     */
    @Test
    public void selectMapsTest() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("id", 6);

        // 传入 QueryWrapper 查询条件对象
        List<Map<String, Object>> maps = employeeMapper.selectMaps(queryWrapper);
        // 遍历 map
        for (Map<String, Object> map : maps) {
            // 打印键值对
            for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
                System.out.println(stringObjectEntry.getKey() + "|" + stringObjectEntry.getValue());
            }
        }
    }

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
     * 删除操作  通过 Id 删除
     */
    @Test
    public void deleteTest() {
        // 通过 Id 删除
        employeeMapper.deleteById(1);
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

    /**
     * 通过 map 删除
     */
    @Test
    public void  deleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("last_name", "Black");

        employeeMapper.deleteByMap(map);
    }

    /**
     * 通过主键批量删除
     */
    @Test
    public void deleteBatchIdsTest(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        employeeMapper.deleteBatchIds(integers);
    }
}
