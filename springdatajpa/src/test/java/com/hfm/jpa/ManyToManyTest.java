package com.hfm.jpa;

import com.hfm.dao.SysRoleDao;
import com.hfm.dao.SysUserDao;
import com.hfm.domain.SysRole;
import com.hfm.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-11 21:04
 * @Description 多对多操作
 * @date 2020/10/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToManyTest {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysUserDao sysUserDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testAdd() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("程序员");

        SysUser sysUser = new SysUser();
        sysUser.setUserName("ptt");
        sysUser.setAge(28);

        // 将用户添加到角色中
        sysRole.getSysUsers().add(sysUser);
        // 或者将角色添加到用户中，如果都进行维护会造成主键冲突
//        sysUser.getSysRoles().add(sysRole);

        // 没有将角色添加到用户 将用户添加到角色中时，角色与用户都是单独添加到数据库中而没有关联起来
        sysRoleDao.save(sysRole);
        sysUserDao.save(sysUser);
    }

    @Test
    @Transactional
    @Rollback(false)//设置为不回滚
    public void testDelete() {
        sysUserDao.delete(1l);
    }
}
