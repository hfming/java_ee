package com.hfm.dao;

import com.hfm.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-10 13:58
 * @Description JpaRepository<实体类类型 ， 主键类型>：用来完成基本CRUD操作
 * JpaSpecificationExecutor<实体类类型>：用于复杂查询（分页等查询操作）
 * @date 2020/10/10
 */
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    /**
     * 查询所有数据
     *
     * @return
     * @Query 使用jpql的方式查询。
     */
    @Query(value = "from Customer ")
    List<Customer> findCustomers();

    /**
     * 通过 id 查询Customer
     *
     * @param id
     * @return
     * @Query 使用jpql的方式查询。?1代表参数的占位符，其中1对应方法中的参数索引
     */
    @Query(value = "from Customer where custId = ?1")
    Customer findCustomerById(Long id);

    /**
     * 此外，也可以通过使用 @Query 来执行一个更新操作，为此，我们需要在使用 @Query 的同时，用 @Modifying 来将该操作标识为修改查询
     * 这样框架最终会生成一个更新的操作，而非查询
     *
     * @param custName
     * @param custId
     */
    @Query(value = "update Customer set custName = ?1 where custId = ?2")
    @Modifying
    void update(String custName, Long custId);

    /**
     * 通过 名称与 Id 查询
     * @param custId
     * @param custName
     * @return
     */
    @Query(value ="from Customer where custId = ?1 and custName = ?2 ")
    Customer findCustomerByIdAnCustName(Long custId, String custName);

    /**
     * 本地 SQL 方式查询
     * 添加 nativeQuery 属才会使用本地 SQL 查询，不然默认使用 JPQL 查询方式
     * @return
     */
    @Query(value = "select * from cst_customer",nativeQuery=true)
    List<Customer> findSQL();

    /**
     * 方法命名方式查询（根据客户名称查询客户）
     * @param custName
     * @return
     */
    public Customer findByCustName(String custName);

    /**
     * 模糊查询
     * @param custName
     * @return
     */
    public Customer findByCustNameContaining(String custName);
}
