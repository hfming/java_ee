package com.hfm.entity;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-21 15:42
 * @Description
 * @date 2020/9/21
 */
public class Test {
    private String uudi;
    private String name;
    private String password;

    public Test(String uudi, String name, String password) {
        this.uudi = uudi;
        this.name = name;
        this.password = password;
    }

    public Test() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Test test = (Test) o;
        return Objects.equals(uudi, test.uudi) &&
                Objects.equals(name, test.name) &&
                Objects.equals(password, test.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uudi, name, password);
    }

    public String getUudi() {
        return uudi;
    }

    public void setUudi(String uudi) {
        this.uudi = uudi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
