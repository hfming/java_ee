package com.hfm.test;

import com.hfm.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-30 12:02
 * @Description
 * @date 2020/10/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AutoTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void  deleteAll(){
        employeeMapper.deleteAll();
    }
}
