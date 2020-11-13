package com.hfm.dao;

import com.hfm.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-11 20:58
 * @Description
 * @date 2020/10/11
 */
public interface SysUserDao extends JpaRepository<SysUser,Long>, JpaSpecificationExecutor<SysUser> {
}
