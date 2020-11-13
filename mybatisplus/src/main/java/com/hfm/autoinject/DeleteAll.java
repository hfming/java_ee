package com.hfm.autoinject;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-30 11:55
 * @Description 这一步实现了mapper中对应方法的sql的功能实现。
 * @date 2020/10/30
 */
public class DeleteAll  extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        /* 执行 SQL ，动态 SQL 参考类 SqlMethod */
        String sql = "delete from " + tableInfo.getTableName();
        /* mapper 接口方法名一致 */
        String method = "deleteAll";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        // 添加 MappedStatement
        return this.addDeleteMappedStatement(mapperClass, method, sqlSource);
    }
}
