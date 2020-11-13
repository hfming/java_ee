package com.hfm.myprovider;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-28 11:38
 * @Description
 * @date 2020/10/28
 */
public class MyBatchProvider extends MapperTemplate {
    public MyBatchProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 接口与类同名方法
     * 返回拼接好的sql 语句
     *
     * @param mappedStatement
     */

    public String batchUpdate(MappedStatement mappedStatement) {
        // 1.获取实体类对象
        Class<?> entityClass = super.getEntityClass(mappedStatement);

        // 2.获取表名
        String tableName = super.tableName(entityClass);

        // 创建 StringBuilder 对象用于拼接sql各个组成部分
        StringBuilder stringBuilder = new StringBuilder();

        // 拼 sql 语句
        stringBuilder.append("<foreach collection=\"list\" item=\"record\" separator=\";\" >");

        // 拼 update 语句
        String updateTable = SqlHelper.updateTable(entityClass, tableName);
        stringBuilder.append(updateTable);

        // 拼 set 子句
        stringBuilder.append("<set>");
        // 获取 所有列(字段)信息
        Set<EntityColumn> columns = EntityHelper.getColumns(entityClass);

        // 存储组件字段名与字段值
        String idColumn = null;
        String idValue = null;

        // 遍历所有字段
        for (EntityColumn column : columns) {
            // 判断字段是否为主键
            if (column.isId()) {
                // 字段名
                idColumn = column.getColumn();
                // 字段值
                idValue = column.getColumnHolder("record");
            } else {
                String columnName = column.getColumn();
                // 与 foreach 标签的 item 对应
                String columnHolder = column.getColumnHolder("record");

                stringBuilder.append(columnName).append("=").append(columnHolder).append(",");
            }
        }
        stringBuilder.append("</set>");

        // 拼 where 子句
        stringBuilder.append("where ").append(idColumn).append("=").append(idValue);
        stringBuilder.append("</foreach>");

        System.out.println(stringBuilder.toString());
        // 返回拼接好的 sql
        return stringBuilder.toString();
    }
}
