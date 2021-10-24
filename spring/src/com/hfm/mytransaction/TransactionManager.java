package com.hfm.mytransaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 */
@Component(value = "myTransactionManage")
@Aspect // 生成代理类
@Order(value = 1) // 设置增强类优先级
public class TransactionManager {
    /**
     * 开启事务
     */
    @Before(value = "execution(* com.hfm.mytransaction.AccountServerImpl.transferAccount(..))")
    public void beginTransaction() {
        try {
            JDBCUtils.getConnectionByDruid();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param proceedingJoinPoint
     */
    @Around(value = "execution(* com.hfm.mytransaction.AccountServerImpl.transferAccount(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            proceedingJoinPoint.proceed();
            // 没有问题提交事务
            commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 出现异常回滚事务
            rollback();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            JDBCUtils.rollbackAndClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
