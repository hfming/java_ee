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
@Table(name = "sys_role")
public class SysRole {
    /**
     * 角色 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    /**
     * 角色名
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 多对多关系
     */
    @ManyToMany(mappedBy = "sysRoles") // 设置关联的实体 // 被动的一方放弃外键的维护 mappedBy 设置维护外键的对象
    private Set<SysUser> sysUsers = new HashSet<>();

    public Set<SysUser> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }

    public SysRole() {
    }

    public SysRole(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SysRole{");
        sb.append("roleId=").append(roleId);
        sb.append(", roleName='").append(roleName).append('\'');
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
        SysRole sysRole = (SysRole) o;
        return Objects.equals(roleId, sysRole.roleId) &&
                Objects.equals(roleName, sysRole.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
