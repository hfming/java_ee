package com.hfm.entity;

import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-20 16:03
 * @Description 联系人
 * @date 2020/9/20
 */
public class Contact {
    private Integer cont_id;
    private String cont_name;
    private String cont_gender;
    private String cont_phone;
    private String cont_mobile;
    private String cont_emali;
    private String cont_qq;
    private String cont_position;
    private String cont_memo;

    /**
     * 保存了所属客户的对象
     */
    private Customer customer;

    public Contact() {
    }

    public Contact(Integer cont_id, String cont_name, String cont_gender, String cont_phone, String cont_mobile, String cont_emali, String cont_qq, String cont_position, String cont_memo, Customer customer) {
        this.cont_id = cont_id;
        this.cont_name = cont_name;
        this.cont_gender = cont_gender;
        this.cont_phone = cont_phone;
        this.cont_mobile = cont_mobile;
        this.cont_emali = cont_emali;
        this.cont_qq = cont_qq;
        this.cont_position = cont_position;
        this.cont_memo = cont_memo;
        this.customer = customer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("cont_id=").append(cont_id);
        sb.append(", cont_name='").append(cont_name).append('\'');
        sb.append(", cont_gender='").append(cont_gender).append('\'');
        sb.append(", cont_phone='").append(cont_phone).append('\'');
        sb.append(", cont_mobile='").append(cont_mobile).append('\'');
        sb.append(", cont_emali='").append(cont_emali).append('\'');
        sb.append(", cont_qq='").append(cont_qq).append('\'');
        sb.append(", cont_position='").append(cont_position).append('\'');
        sb.append(", cont_memo='").append(cont_memo).append('\'');
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
        Contact contact = (Contact) o;
        return Objects.equals(cont_id, contact.cont_id) &&
                Objects.equals(cont_name, contact.cont_name) &&
                Objects.equals(cont_gender, contact.cont_gender) &&
                Objects.equals(cont_phone, contact.cont_phone) &&
                Objects.equals(cont_mobile, contact.cont_mobile) &&
                Objects.equals(cont_emali, contact.cont_emali) &&
                Objects.equals(cont_qq, contact.cont_qq) &&
                Objects.equals(cont_position, contact.cont_position) &&
                Objects.equals(cont_memo, contact.cont_memo) &&
                Objects.equals(customer, contact.customer);
    }

    public Integer getCont_id() {
        return cont_id;
    }

    public void setCont_id(Integer cont_id) {
        this.cont_id = cont_id;
    }

    public String getCont_name() {
        return cont_name;
    }

    public void setCont_name(String cont_name) {
        this.cont_name = cont_name;
    }

    public String getCont_gender() {
        return cont_gender;
    }

    public void setCont_gender(String cont_gender) {
        this.cont_gender = cont_gender;
    }

    public String getCont_phone() {
        return cont_phone;
    }

    public void setCont_phone(String cont_phone) {
        this.cont_phone = cont_phone;
    }

    public String getCont_mobile() {
        return cont_mobile;
    }

    public void setCont_mobile(String cont_mobile) {
        this.cont_mobile = cont_mobile;
    }

    public String getCont_emali() {
        return cont_emali;
    }

    public void setCont_emali(String cont_emali) {
        this.cont_emali = cont_emali;
    }

    public String getCont_qq() {
        return cont_qq;
    }

    public void setCont_qq(String cont_qq) {
        this.cont_qq = cont_qq;
    }

    public String getCont_position() {
        return cont_position;
    }

    public void setCont_position(String cont_position) {
        this.cont_position = cont_position;
    }

    public String getCont_memo() {
        return cont_memo;
    }

    public void setCont_memo(String cont_memo) {
        this.cont_memo = cont_memo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
