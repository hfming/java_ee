package com.hfm.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-11 20:11
 * @Description
 * @date 2020/10/11
 */
@Component
@Entity
@Table(name = "sys_user")
public class SysUser {
    /**
     * 用户 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String UserName;
    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 多对多的关系
     */
    @ManyToMany(targetEntity = SysRole.class,fetch = FetchType.LAZY) // 设置关联的实体
    @JoinTable(
            // name 属性设置第三张表的名称
            name = "sys_user_role",
            // joinColumns 配置当前对象在中间表中的外键
            joinColumns = {@JoinColumn(name = "sys_user_id", referencedColumnName = "user_id")},
            // inverseForeignKey 属性配置对方在中间表的外键
            inverseJoinColumns = {@JoinColumn(name = "sys_role_id", referencedColumnName = "role_id")})
    private Set<SysRole> sysRoles = new HashSet<>();

    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public SysUser() {
    }

    public SysUser(Long userId, String userName, Integer age) {
        this.userId = userId;
        UserName = userName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysUser sysUser = (SysUser) o;
        return Objects.equals(userId, sysUser.userId) &&
                Objects.equals(UserName, sysUser.UserName) &&
                Objects.equals(age, sysUser.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, UserName, age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SysUser{");
        sb.append("userId=").append(userId);
        sb.append(", UserName='").append(UserName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
