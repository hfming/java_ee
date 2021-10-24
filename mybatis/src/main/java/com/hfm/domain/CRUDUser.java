package com.hfm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-21 16:00
 * @Description
 * @date 2020/10/21
 */
public class CRUDUser implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public CRUDUser() {
    }

    public CRUDUser(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserFirst{");
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
        CRUDUser userFirst = (CRUDUser) o;
        return Objects.equals(id, userFirst.id) && Objects.equals(username, userFirst.username) && Objects.equals(birthday, userFirst.birthday) && Objects.equals(sex, userFirst.sex) && Objects.equals(address, userFirst.address);
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
