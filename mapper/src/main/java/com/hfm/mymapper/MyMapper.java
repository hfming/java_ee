package com.hfm.mymapper;

import com.hfm.myprovider.MyBatchUpdateMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-27 22:12
 * @Description 通过重组 mapper 接口的父类可以自定义 mapper 接口
 * @date 2020/10/27
 */
public interface MyMapper<T> extends BaseSelectMapper<T>, RowBoundsMapper<T>, MyBatchUpdateMapper<T> {
}
