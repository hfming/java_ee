package com.hfm.utils.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-06 11:17
 * @Description String 类型转化成 Date 类型数据
 * @date 2020/10/6
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (s == null || "".equalsIgnoreCase(s.trim()) || "null".equalsIgnoreCase(s.trim())) {
            throw new NullPointerException("输入的日期为空！");
        }
        Date parse = null;
        SimpleDateFormat simpleDateFormat = null;
        try {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parse = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("类型转换出错！");
        } finally {
            return parse;
        }
    }
}
