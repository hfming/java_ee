package com.hfm.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-13 22:41
 * @Description
 * @date 2020/10/13
 */
@Component(value = "person")
public class Person {
    private Integer id;
    @Value("hfm")
    private String name;
    @Value("17111711")
    private String password;

    @PostConstruct // 在 bean 赋值完成并且属性赋值完成时执行初始化方法
    public void init(){
        System.out.println("初始化方法");
    }
    @PreDestroy // 在 bean 销毁前调用销毁方法
    public void destory(){
        System.out.println("销毁方法");
    }

    public Person() {
    }

    public Person(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
