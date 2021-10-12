package com.hfm.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-20 16:03
 * @Description 客户
 * 一个客户可以对应多个联系人
 * @date 2020/9/20
 */
public class Customer {
    private Integer cust_id;
    private String cust_name;
    private String cust_source;
    private String cust_industry;
    private String cust_level;
    private String cust_phone;
    private String cust_mobile;
    /**
     * 一个客户可以对应多个联系人
     */
    private Set<Contact> contacts = new HashSet<>();

    public Customer() {
    }

    public Customer(Integer cust_id, String cust_name, String cust_source, String cust_industry, String cust_level, String cust_phone, String cust_mobile, HashSet<Contact> contacts) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_source = cust_source;
        this.cust_industry = cust_industry;
        this.cust_level = cust_level;
        this.cust_phone = cust_phone;
        this.cust_mobile = cust_mobile;
        this.contacts = contacts;
    }

    public Customer(String cust_name, String cust_level) {
        this.cust_name = cust_name;
        this.cust_level = cust_level;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("cust_id=").append(cust_id);
        sb.append(", cust_name='").append(cust_name).append('\'');
        sb.append(", cust_source='").append(cust_source).append('\'');
        sb.append(", cust_industry='").append(cust_industry).append('\'');
        sb.append(", cust_level='").append(cust_level).append('\'');
        sb.append(", cust_phone='").append(cust_phone).append('\'');
        sb.append(", cust_mobile='").append(cust_mobile).append('\'');
        sb.append(", contacts=").append(contacts);
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
        Customer customer = (Customer) o;
        return Objects.equals(cust_id, customer.cust_id) &&
                Objects.equals(cust_name, customer.cust_name) &&
                Objects.equals(cust_source, customer.cust_source) &&
                Objects.equals(cust_industry, customer.cust_industry) &&
                Objects.equals(cust_level, customer.cust_level) &&
                Objects.equals(cust_phone, customer.cust_phone) &&
                Objects.equals(cust_mobile, customer.cust_mobile) &&
                Objects.equals(contacts, customer.contacts);
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_source() {
        return cust_source;
    }

    public void setCust_source(String cust_source) {
        this.cust_source = cust_source;
    }

    public String getCust_industry() {
        return cust_industry;
    }

    public void setCust_industry(String cust_industry) {
        this.cust_industry = cust_industry;
    }

    public String getCust_level() {
        return cust_level;
    }

    public void setCust_level(String cust_level) {
        this.cust_level = cust_level;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
