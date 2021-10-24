package com.hfm.noioc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-14 17:34
 * @Description
 * @date 2021/10/14
 */
public class JDBCUtils {
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        return dataSource;
    }

    static {
        try {
            // 1. 通过反射加载 properties 配置文件
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");

            Properties properties = new Properties();
            properties.load(resourceAsStream);

            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 用于存储当前线程共享的数据库连接对象
     */
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    /**
     * 使用 Druid 数据库连接池，创建数据库连接对象
     *
     * @return 数据库连接对象
     */
    public static Connection getConnectionByDruid() {
//      return dataSource.getConnection();
        Connection connection = conns.get();

        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                // 手动开启线程
                connection.setAutoCommit(false);
                // 保存到 ThreadLocal 对象中，供后面的 jdbc 操作使用
                conns.set(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose() {
        Connection conection = conns.get();
        // 如果不等于 nul，说明 之前使用过连接，操作过数据库
        if (conection != null) {
            try {
                // 提交事务
                conection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭连接，资源资源
                    conection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose() {
        Connection conection = conns.get();
        // 如果不等于 null，说明 之前使用过连接，操作过数据库
        if (conection != null) {
            try {
                //回滚事务
                conection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭连接，资源资源
                    conection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }
}
