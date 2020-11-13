package com.hfm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-27 10:32
 * @Description 实体类
 * @date 2020/10/27
 */
@Table(name = "mapper_emp") // 默认表明就是实体类的名称，如果表明与实体类的名称不同需要使用 @Teable 注解指定表与实体类之间的映射关系
public class Employee implements Serializable {
    @Id
    @Column(name = "emp_id") // 同样的默认字段名也与属性名相同，如果不同需要使用@Cloumn 指定字段与属性的映射关系
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略 mysql 使用自动增长策略 GenerationType.IDENTITY oralce 使用  GenerationType.SEQUENCE 策略
    private Integer empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_salary")
    private Double empSalary;
    @Column(name = "emp_age")
    private Integer empAge;

    public Employee() {
    }

    public Employee(Integer empId, String empName, Double empSalary, Integer empAge) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
    }

    @Override
    public String
    toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("empId=").append(empId);
        sb.append(", empName='").append(empName).append('\'');
        sb.append(", empSalary=").append(empSalary);
        sb.append(", empAge=").append(empAge);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(empId, employee.empId) &&
                Objects.equals(empName, employee.empName) &&
                Objects.equals(empSalary, employee.empSalary) &&
                Objects.equals(empAge, employee.empAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empSalary, empAge);
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }
}
