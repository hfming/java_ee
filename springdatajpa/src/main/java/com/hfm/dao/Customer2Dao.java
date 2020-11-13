package com.hfm.dao;

import com.hfm.domain.Customer2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-10 13:58
 * @Description JpaRepository<实体类类型 ， 主键类型>：用来完成基本CRUD操作
 * JpaSpecificationExecutor<实体类类型>：用于复杂查询（分页等查询操作）
 * @date 2020/10/10
 */
public interface Customer2Dao extends JpaRepository<Customer2, Long>, JpaSpecificationExecutor<Customer2> {
}
