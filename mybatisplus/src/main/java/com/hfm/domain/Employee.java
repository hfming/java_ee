package com.hfm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-26 21:43
 * @Description 实体类
 * @date 2020/10/26
 */
@TableName(value = "mp_employee")
@Component
public class Employee extends Model<Employee> implements Serializable  {
    /**
     * 仅仅需要让实体类继承Model类且实现主键指定方法，即可开启AR
     * @return
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    /**
     * @TableId 注解用于配置主键字段
     * value 属性指定表中的主键字段，如果表字段与实体类属性相同可以不用设置 value 属性，如果不同则必须设置value 属性
     * type 属性指定 主键生成策略，mysql 使用 数据库自增 id
     */
    @TableId(type = IdType.AUTO) // 设置主键生成策略
    private Integer id;
    /**
     * @TableField 注解用于配置非主键字段
     * value 属性指定表对于的字段，如果表字段与实体类属性相同可以不用设置 value 属性，如果不同则必须设置value 属性
     */
    @TableField(value = "last_name")
    private String lastName;
    @TableField(value = "email")
    private String email;
    @TableField(value = "gender")
    private Integer gender;
    @TableField(value = "age")
    private Integer age;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Integer age) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
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
        return Objects.equals(id, employee.id) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(age, employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, email, gender, age);
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
