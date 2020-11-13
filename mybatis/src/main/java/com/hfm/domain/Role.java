package com.hfm.domain;

import java.util.List;
import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-23 19:41
 * @Description
 * @date 2020/10/23
 */
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    /**
     * 多对多关系，各自有内部关联对象的集合
     */
    private List<RoleUser> users;

    public List<RoleUser> getUsers() {
        return users;
    }

    public void setUsers(List<RoleUser> users) {
        this.users = users;
    }

    public Role() {
    }

    public Role(Integer roleId, String roleName, String roleDesc) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("roleId=").append(roleId);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append(", roleDesc='").append(roleDesc).append('\'');
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
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(roleDesc, role.roleDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleDesc);
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
