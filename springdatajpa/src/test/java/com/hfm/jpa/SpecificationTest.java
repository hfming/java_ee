package com.hfm.jpa;

import com.hfm.dao.CustomerDao;
import com.hfm.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.Comparator;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-10 21:25
 * @Description Specification 动态查询
 * @date 2020/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class SpecificationTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 动态条件查询
     */
    @Test
    public void whereTest() {
        // 条件查询插入一个 Specification 条件对象
        // 需要实现 Specification 接口(提供泛型，查询对象的类型)
        // 需要借助 toPredicate 方法
        // root 对象代表查询的根对象
        // CriteriaQuery对象代表 顶层查询对象，自定义查询方式
        // CriteriaBuilder 代表查询的构造器，封装了很多的查询条件
        Customer customer = customerDao.findOne((root, criteriaQuery, criteriaBuilder) -> {
            // 获取比较的属性
            // 从实体Customer对象中按照custName属性进行查询
            Path<Object> custName = root.get("custName");

            // 构造查询条件
            // 参数一：需要比较的属性
            // 参数二：比较的值
            Predicate predicate = criteriaBuilder.equal(custName, "传智学院");
            return predicate;
        });

        System.out.println(customer);
    }

    /**
     * 多条件查询
     */
    @Test
    public void matchWhereTest() {
        List<Customer> customers = customerDao.findAll((root, criteriaQuery, criteriaBuilder) -> {
            Path<Object> custName = root.get("custName");
            Path<Object> custIndustry = root.get("custIndustry");

            Predicate predicate1 = criteriaBuilder.equal(custName, "传智学院");
            Predicate predicate2 = criteriaBuilder.equal(custIndustry, "it教育");

            // 将两个查询条件组合到一起
            // 与关系 or
            // 或关系 and
            Predicate and = criteriaBuilder.and(predicate1, predicate2);
            return and;
        });

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * 模糊查询
     */
    @Test
    public void likeTest() {
        List<Customer> customers = customerDao.findAll((root, criteriaQuery, criteriaBuilder) -> {
            Path<Object> custName = root.get("custName");

            // gt, lt ,le ,like 方法需要得到 path 对象,根据 path 对象指定比较的参数类型，再进行比较
            Predicate predicate = criteriaBuilder.like(custName.as(String.class), "%传智%");
            return predicate;
        });

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * 排序查询，需要插入一个 Sort 对象
     */
    @Test
    public void orderTest() {
        List<Customer> customers = customerDao.findAll((root, criteriaQuery, criteriaBuilder) -> {
            Path<Object> custName = root.get("custName");

            // gt, lt ,le ,like 方法需要得到 path 对象,根据 path 对象指定比较的参数类型，再进行比较
            Predicate predicate = criteriaBuilder.like(custName.as(String.class), "%%");
            return predicate;
        }, new Sort(Sort.Direction.DESC, "custName")); // Sort.Direction.DESC Sort.Direction.ASC

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * 分页查询
     * 需要传入一个 Pageable 接口的实现类对象，返回一个分页对象
     */
    @Test
    public void pageTest() {
        // 返回一个分页对象
        Page<Customer> customers = customerDao.findAll((root, criteriaQuery, criteriaBuilder) -> {
            Path<Object> custName = root.get("custName");

            Predicate predicate = criteriaBuilder.equal(custName, "传智学院");
            return predicate;
        }, new PageRequest(0, 2));

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
