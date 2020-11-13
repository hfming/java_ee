package com.hfm.factory;

import java.util.LinkedHashMap;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-20 19:29
 * @Description
 * @date 2020/10/20
 */
public class FilterChainDefinitionMapBuilder {
    private LinkedHashMap<String,String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();
        // 设置页面权限
        stringStringLinkedHashMap.put("/login.jsp", "anno");

        return stringStringLinkedHashMap;
    }
}
