package com.hfm.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-09 11:57
 * @Description 客户实体类
 * @date 2020/10/9
 */
@Entity() // @Entity 声明实体类
@Table(name = "cst_customer2") // @Table 配置实体类与表的映射关系 name属性配置表的名称
public class Customer2 {
    /**
     * 客户编号
     */
    @Id  // 声明主键配置
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue 配置主键生成策略 GenerationType.IDENTITY 自增长
    @Column(name = "cust_id")  // @Column 配置实体类中属性与表中字段的映射关系 name 属性：表中的字段名
    private Long custId;
    /**
     * 客户名称(公司名称)
     */
    @Column(name = "`cust_name`") //指定和表中cust_name字段的映射关系
    private String custName;
    /**
     * 客户信息来源
     */
    @Column(name = "`cust_source`") //指定和表中cust_source字段的映射关系
    private String custSource;
    /**
     * 客户所属行业
     */
    @Column(name = "`cust_industry`") //指定和表中cust_industry字段的映射关系
    private String custIndustry;
    /**
     * 客户级别
     */
    @Column(name = "`cust_level`") //指定和表中cust_level字段的映射关系
    private String custLevel;
    /**
     * 客户联系地址
     */
    @Column(name = "`cust_address`") //指定和表中cust_address字段的映射关系
    private String custAddress;
    /**
     * 客户联系电话
     */
    @Column(name = "`cust_phone`") //指定和表中cust_phone字段的映射关系
    private String custPhone;

    /**
     * 客户有多个联系人实体
     *
     * @OneToMany 配置一对多关系
     * targetEntity 属性配置关联的实体类字节码对象
     * @JoinColumn 配置外键
     * name 属性配置外键名
     * referencedColumnName 属性主表的主键字段名称
     * cascade:配置级联操作
     * 		CascadeType.MERGE	级联更新
     * 		CascadeType.PERSIST	级联保存：
     * 		CascadeType.REFRESH 级联刷新：
     * 		CascadeType.REMOVE	级联删除：
     * 		CascadeType.ALL		包含所有
     * 在客户对象的@OneToMany注解中添加fetch属性
     * FetchType.EAGER	：立即加载
     * FetchType.LAZY	：延迟加载
     */
    //    @OneToMany(targetEntity = LinkMan2.class) // 配置实体类之间的关系
    //    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id") // 声明外键
    @OneToMany(mappedBy = "customer2", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 放弃外键的维护权 mappedBy 属性指定维护外键的对象
    private Set<LinkMan2> linkMan2 = new HashSet<>();

    public Set<LinkMan2> getLinkMan2() {
        return linkMan2;
    }

    public void setLinkMan2(Set<LinkMan2> linkMan2) {
        this.linkMan2 = linkMan2;
    }

    public Customer2() {
    }

    public Customer2(Long custId, String custName, String custSource, String custIndustry, String custLevel, String custAddress, String custPhone) {
        this.custId = custId;
        this.custName = custName;
        this.custSource = custSource;
        this.custIndustry = custIndustry;
        this.custLevel = custLevel;
        this.custAddress = custAddress;
        this.custPhone = custPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer2 customer = (Customer2) o;
        return Objects.equals(custId, customer.custId) &&
                Objects.equals(custName, customer.custName) &&
                Objects.equals(custSource, customer.custSource) &&
                Objects.equals(custIndustry, customer.custIndustry) &&
                Objects.equals(custLevel, customer.custLevel) &&
                Objects.equals(custAddress, customer.custAddress) &&
                Objects.equals(custPhone, customer.custPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId, custName, custSource, custIndustry, custLevel, custAddress, custPhone);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("custId=").append(custId);
        sb.append(", custName='").append(custName).append('\'');
        sb.append(", custSource='").append(custSource).append('\'');
        sb.append(", custIndustry='").append(custIndustry).append('\'');
        sb.append(", custLevel='").append(custLevel).append('\'');
        sb.append(", custAddress='").append(custAddress).append('\'');
        sb.append(", custPhone='").append(custPhone).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }
}
