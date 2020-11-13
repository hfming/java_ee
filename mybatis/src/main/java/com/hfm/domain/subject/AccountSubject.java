package com.hfm.domain.subject;

import com.hfm.domain.Account;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-23 17:25
 * @Description
 * @date 2020/10/23
 */
public class AccountSubject extends Account {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("AccountSubject{");
        sb.append("username='").append(username).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
