package com.hfm.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hfm.domain.Emp;
import com.hfm.mapper.EmpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-11-01 11:51
 * @Description
 * @date 2020/11/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmpMapperTest {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void findAllTest(){
//        List<Emp> emps = empMapper.findAll(1, 5);
//        for (Emp emp : emps) {
//            System.out.println(emp);
//            System.out.println(emp.getDept());
//        }
    }

    @Test
    public void pageTest(){
//        Page<Emp> empPage = new Page<>(1, 2);
//        empPage = empMapper.selectPage(empPage, null);
//
//        List<Emp> records = empPage.getRecords();
//        for (Emp record : records) {
//            System.out.println(record);
//            System.out.println(record.getDept());
//        }
    }
}
