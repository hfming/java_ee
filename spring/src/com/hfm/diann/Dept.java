package com.hfm.diann;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-27 17:24
 * @Description 部门类(一)
 * @date 2020/9/27
 */
@Component(value = "dept")
public class Dept {
    private Integer deptId;
    @Value(value = "科技部")
    private String deptName;

//    /**
//     * 一对多关系中的一,一中有多个多,需要有集合存储多的对象
//     */
//    private List<Employee> employees = new ArrayList<>();
//
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    /**
//     * 属性注入
//     *
//     * @param employees
//     */
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }

    public Dept() {
    }

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dept{");
        sb.append("deptId=").append(deptId);
        sb.append(", deptName='").append(deptName).append('\'');
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
        Dept dept = (Dept) o;
        return Objects.equals(deptId, dept.deptId) &&
                Objects.equals(deptName, dept.deptName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName);
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
