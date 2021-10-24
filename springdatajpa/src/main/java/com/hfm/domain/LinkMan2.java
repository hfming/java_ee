package com.hfm.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-11 11:59
 * @Description
 * @date 2020/10/11
 */
@Entity // 声明实体类
@Table(name = "cst_linkman2") // @Table 配置实体类与表的映射关系 name属性配置表的名称
public class LinkMan2 {
    /**
     * 联系人 ID
     */
    @Id // 声明主键配置
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // @GeneratedValue 配置主键生成策略 GenerationType.IDENTITY 自增长
    @Column(name = "lkm_id")  // @Column 配置实体类中属性与表中字段的映射关系 name 属性：表中的字段名
    private Long lkmId;
    /**
     * 联系人姓名
     */
    @Column(name = "lkm_name")
    private String lkmName;
    /**
     * 联系人性别
     */
    @Column(name = "lkm_gender")
    private String lkmGender;
    /**
     * 联系人手机
     */
    @Column(name = "lkm_phone")
    private String lkmPhone;
    /**
     * 联系人电话
     */
    @Column(name = "lkm_mobile")
    private String lkmMobile;
    /**
     * 联系人地址
     */
    @Column(name = "lkm_position")
    private String lkmPosition;
    /**
     * 联系人 备注
     */
    @Column(name = "lkm_memo")
    private String lkmMemo;

    /**
     * 联系人所属的客户
     * @return
     * @ManyToOne 配置多对一的关系
     */
    @ManyToOne(targetEntity = Customer2.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    private Customer2 customer2;

    public Customer2 getCustomer2() {
        return customer2;
    }

    public void setCustomer2(Customer2 customer2) {
        this.customer2 = customer2;
    }

    public LinkMan2() {
    }

    public LinkMan2(Long lkmId, String lkmName, String lkmGender, String lkmPhone, String lkmMobile, String lkmPosition, String lkmMemo) {
        this.lkmId = lkmId;
        this.lkmName = lkmName;
        this.lkmGender = lkmGender;
        this.lkmPhone = lkmPhone;
        this.lkmMobile = lkmMobile;
        this.lkmPosition = lkmPosition;
        this.lkmMemo = lkmMemo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkMan2 linkMan = (LinkMan2) o;
        return Objects.equals(lkmId, linkMan.lkmId) &&
                Objects.equals(lkmName, linkMan.lkmName) &&
                Objects.equals(lkmGender, linkMan.lkmGender) &&
                Objects.equals(lkmPhone, linkMan.lkmPhone) &&
                Objects.equals(lkmMobile, linkMan.lkmMobile) &&
                Objects.equals(lkmPosition, linkMan.lkmPosition) &&
                Objects.equals(lkmMemo, linkMan.lkmMemo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lkmId, lkmName, lkmGender, lkmPhone, lkmMobile, lkmPosition, lkmMemo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinkMan{");
        sb.append("lkmId=").append(lkmId);
        sb.append(", lkmName='").append(lkmName).append('\'');
        sb.append(", lkmGender='").append(lkmGender).append('\'');
        sb.append(", lkmPhone='").append(lkmPhone).append('\'');
        sb.append(", lkmMobile='").append(lkmMobile).append('\'');
        sb.append(", lkmPosition='").append(lkmPosition).append('\'');
        sb.append(", lkmMemo='").append(lkmMemo).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }
}
