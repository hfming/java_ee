package com.hfm.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-16 18:10
 * @Description 员工实体
 * @date 2020/10/16
 */
@Entity
@Table(name = "sssp_employee")
public class Employee {
    @Id // 声明主键配置
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略
    @Column(name = "id")
    private Integer id;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "birth")
    private Date birth;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createTime")
    private Date createTime;

    /**
     * 单向多对一关系，员工所属的部门
     */
    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "dept_emp_id", referencedColumnName = "id")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Date birth, Date createTime) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.birth = birth;
        this.createTime = createTime;
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
        return Objects.equals(id, employee.id) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(birth, employee.birth) &&
                Objects.equals(createTime, employee.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, email, birth, createTime);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", birth=").append(birth);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
