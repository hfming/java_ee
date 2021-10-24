package com.hfm.noioc;

/**
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 */
public class TransactionManager {
    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
            JDBCUtils.getConnectionByDruid();
        } catch (Exception e) {
            e.printStackTrace();
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
