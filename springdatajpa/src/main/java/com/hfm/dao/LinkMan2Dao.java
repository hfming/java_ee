package com.hfm.dao;


import com.hfm.domain.LinkMan2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-11 13:12
 * @Description
 * @date 2020/10/11
 */
public interface LinkMan2Dao extends JpaRepository<LinkMan2,Long>, JpaSpecificationExecutor<LinkMan2> {
}
