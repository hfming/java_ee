package com.hfm.mybatis.config;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 10:39
 * @Description 用于封装执行的 sql 语句和结果类型的全类名
 * @date 2020/10/22
 */
public class MyMapper {
    private String sql;
    private String resultType;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
