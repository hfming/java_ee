package com.hfm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-20 18:00
 * @Description 用户实体类
 *
 * @date 2020/9/20
 */
public class NewUser {
    private Long user_id;
    private String user_name;
    private String user_password;
    private String user_state;
    /**
     * 多对多关系
     */
    private Set<Role> roles = new HashSet<>();

    public NewUser() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewUser{");
        sb.append("user_id=").append(user_id);
        sb.append(", user_name='").append(user_name).append('\'');
        sb.append(", user_password='").append(user_password).append('\'');
        sb.append(", user_state='").append(user_state).append('\'');
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_state() {
        return user_state;
    }

    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }
}