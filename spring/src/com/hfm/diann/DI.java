package com.hfm.diann;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-28 19:00
 * @Description 基于注解方式的属性注入
 * 基于配置文件方式的属性注入有三种方式 set 方法,p 名称空间,有参构造函数
 * 基于注解式的属性注入不需要添加set方法
 * @date 2020/9/28
 */
@Controller(value = "di")
@Scope("singleton") // 生命周期相关
public class DI {
    /**
     * @Autowired 根据类型进行注入
     */
    @Autowired
    private EmployeeServer employeeServer;

    /**
     * @Autowired 根据类型进行注入
     */
    @Autowired
    /**
     * @Qualifier 必须与 @Autowired 一起使用
     * @Qualifier 根据名称进行注入, 指定注入的bean
     * 在按照类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注入时可以
     * 当属性为接口 抽象类 父类 父接口 时,会有多个实现类或子类,多个子类必须指定属性的 bean.因此必须使用  @Qualifier 指定具体的 bean
     */
    @Qualifier(value = "employeeDaoImpl1")
    private EmployeeDao employeeDao;

    /**
     * @Resource 既可以根据类型注入, 也可以根据名称注入
     * 不配置 value 属性则根据类型注入
     * 配置 value 属性则根据类型注入
     */
    @Resource(name = "employeeDaoImpl2")
    private EmployeeDao employeeDao2;

    /**
     * @Value 注入普通属性
     */
    @Value("hfm")
    private String name;

    /**
     * @PostConstruct 初始化构造函数
     */
    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行了");
    }

    /**
     * @PreDestroy 销毁方法
     */
    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法执行了");
    }

    public EmployeeServer getEmployeeServer() {
        return employeeServer;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public EmployeeDao getEmployeeDao2() {
        return employeeDao2;
    }

    public String getName() {
        return name;
    }
}
