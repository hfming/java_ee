package com.hfm.test;

import com.hfm.dao.UserMapper;
import com.hfm.domain.Employee;
import com.hfm.mapper.EmployeeMapper;
import com.hfm.mapper.EmployeeMapper2;
import com.hfm.pojo.User;
import com.hfm.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-27 16:56
 * @Description
 * @date 2020/10/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml") // 指定加载配置文件
public class EmployeeMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    /**
     * 通过 id 查询
     */
    @Test
    public void findById() {
        Employee employee = employeeService.findById(1);
        System.out.println(employee);
    }

    /**
     * selectOne 方法测试
     */
    @Test
    public void selectOneTest() {
        // 查询条件对象，属性不为空的字段会自动查询
        Employee employee = new Employee();
        employee.setEmpName("tom");

        // 传入 employee 查询条件
        Employee employeeOut = employeeMapper.selectOne(employee);

        System.out.println(employeeOut);
    }

    /**
     * selectByPrimaryKey 通过主键查询
     */
    @Test
    public void selectByPrimaryKeyTet() {
        Employee employee = employeeMapper.selectByPrimaryKey(1);

        System.out.println(employee);
    }

    /**
     * existsWithPrimaryKey 主键是否存在
     */
    @Test
    public void exitsByPrimaryKeyTest() {
        boolean b = employeeMapper.existsWithPrimaryKey(1);

        System.out.println(b);
    }

    /**
     * insert 保存数据
     */
    @Test
    public void insertTest() {
        Employee employee = new Employee();
        employee.setEmpName("tom");
        employee.setEmpAge(23);
        employee.setEmpSalary(1000.0);

        int insert = employeeMapper.insert(employee);
        System.out.println(insert);

        // 获取插入主键的值
        System.out.println(employee.getEmpId());
    }

    /**
     * insertSelective 插入数据
     */
    @Test
    public void selectSelectiveTest() {
        Employee employee = new Employee();
        employee.setEmpName("tom");

        // 非主键字段如果为null值，则不加入到SQL语句中。
        employeeMapper.insertSelective(employee);
    }

    /**
     * updateByPrimaryKey  通过 主键值更新
     */
    @Test
    public void updateByPrimaryKeyTest(){
        Employee employee = employeeMapper.selectByPrimaryKey(1);

        employee.setEmpName("new Tom");

        // 通过 主键值更新
        employeeMapper.updateByPrimaryKey(employee);
    }

    /**
     * 根据 查询出来的实体类进行删除
     */
    @Test
    public void deleteTest() {
        Employee employee = employeeMapper.selectByPrimaryKey(1);
        employeeMapper.delete(employee);
    }

    /**
     * 通过主键删除数据
     */
    @Test
    public void deleteByPrimaryKeyTest(){
        employeeMapper.deleteByPrimaryKey(1);
    }

    /**
     * qbc 查询
     */
    @Test
    public void  qbcTest(){
        // 目标 (where emp_salary>? and emp_age <? ) or (emp_salary<? and emp_age>?)
        // 创建 Exmaple 对象
        Example example = new Example(Employee.class);

        // 创建 Criteria 对象
        Example.Criteria criteria1 = example.createCriteria();
        Example.Criteria criteria2 = example.createCriteria();

        // 条件一
        criteria1.andGreaterThan("empSalary", 1000.0).andLessThan("empAge", 25);

        // 条件二
        criteria2.andLessThan("empSalary", 3000.0).andGreaterThan("empAge", 55);

        //4.使用OR关键词组装两个Criteria对象
        example.or(criteria2);

        List<Employee> employees = employeeMapper.selectByExample(example);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * 通用 Mapper 逆向工程生成代码测试
     */
    @Autowired
    private UserMapper userMapper;
    @Test
    public void mbgTest(){
        List<User> users = userMapper.selectAll();

        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 自定义 mapper 测试
     */
    @Autowired
    private EmployeeMapper2 employeeMapper2;
    @Test
    public void  myMapperTest(){
        List<Employee> employees = employeeMapper2.selectAll();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
