package com.hfm.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-23 19:42
 * @Description
 * @date 2020/10/23
 */
public class RoleUser {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    /**
     * 多对多关系，各自有内部关联对象的集合
     */
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public RoleUser() {
    }

    public RoleUser(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoleUser{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", address='").append(address).append('\'');
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
        RoleUser roleUser = (RoleUser) o;
        return Objects.equals(id, roleUser.id) &&
                Objects.equals(username, roleUser.username) &&
                Objects.equals(birthday, roleUser.birthday) &&
                Objects.equals(sex, roleUser.sex) &&
                Objects.equals(address, roleUser.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, birthday, sex, address);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
