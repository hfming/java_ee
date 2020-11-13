package com.hfm.dixml;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-27 17:24
 * @Description 员工类(多)
 * @date 2020/9/27
 */
public class Employee {
    private Integer empId;
    private String empName;
    private String empGender;

    /**
     * 一对多关系中的多,需要指定多所在的一
     */
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    /**
     * 内部 bean 属性注入
     *
     * @param dept
     */
    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Employee() {
    }

    public Employee(Integer empId, String empName, String empGender) {
        this.empId = empId;
        this.empName = empName;
        this.empGender = empGender;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("empId=").append(empId);
        sb.append(", empName='").append(empName).append('\'');
        sb.append(", empGender='").append(empGender).append('\'');
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
                Objects.equals(empGender, employee.empGender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empGender);
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

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }
}
