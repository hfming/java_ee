package com.hfm.test;

import com.hfm.domain.Employee;
import com.hfm.mapper.EmployeeMapper2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-28 12:06
 * @Description
 * @date 2020/10/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml") // 指定加载配置文件
public class BatchTest {
    @Autowired
    private EmployeeMapper2 employeeMapper2;

    @Test
    public void batchTest() {
        List<Employee> employees = employeeMapper2.selectAll();

        employeeMapper2.batchUpdate(employees);
    }
}
