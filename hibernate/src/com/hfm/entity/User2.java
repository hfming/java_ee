package com.hfm.entity;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-19 15:16
 * @Description 实体类
 * @date 2020/9/19
 */
public class User2 {
    /**
     * hibernate 要求实体类要有一个唯一的字段
     */
    private String uuid;
    private String username;
    private String password;
    private String address;

    public User2() {
    }

    public User2(String uuid, String username, String password, String address) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User2 user2 = (User2) o;
        return Objects.equals(uuid, user2.uuid) &&
                Objects.equals(username, user2.username) &&
                Objects.equals(password, user2.password) &&
                Objects.equals(address, user2.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, username, password, address);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User2{");
        sb.append("uuid='").append(uuid).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
