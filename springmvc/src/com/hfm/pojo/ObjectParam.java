package com.hfm.pojo;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-05 21:42
 * @Description 对象数据类型中的对象类型属性
 * @date 2020/10/5
 */
@Component(value = "objectParam")
public class ObjectParam {
    private User user;

    public ObjectParam() {
    }

    public ObjectParam(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ObjectParam{");
        sb.append("user=").append(user);
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
        ObjectParam that = (ObjectParam) o;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
