package com.hfm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-20 18:02
 * @Description 角色实体类
 * @date 2020/9/20
 */
public class Role {
    private Long role_id;
    private String role_name;
    private String role_memo;
    /**
     *多对多关系
     */
    private Set<NewUser> newUsers = new HashSet<>();

    public Role() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("role_id=").append(role_id);
        sb.append(", role_name='").append(role_name).append('\'');
        sb.append(", role_memo='").append(role_memo).append('\'');
        sb.append(", newUsers=").append(newUsers);
        sb.append('}');
        return sb.toString();
    }

    public Set<NewUser> getNewUsers() {
        return newUsers;
    }

    public void setNewUsers(Set<NewUser> newUsers) {
        this.newUsers = newUsers;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_memo() {
        return role_memo;
    }

    public void setRole_memo(String role_memo) {
        this.role_memo = role_memo;
    }
}
