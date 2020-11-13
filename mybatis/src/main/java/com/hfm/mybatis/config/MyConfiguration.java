package com.hfm.mybatis.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 10:31
 * @Description 存储配置文件中的信息
 * @date 2020/10/22
 */
public class MyConfiguration {
    private String dirver;
    private String url;
    private String username;
    private String password;
    private Map<String, MyMapper> mappers = new HashMap<>();

    public String getDirver() {
        return dirver;
    }

    public void setDirver(String dirver) {
        this.dirver = dirver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, MyMapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, MyMapper> mappers) {
        // 将传入的 mappers 追加进来，而不是覆盖
        this.mappers.putAll(mappers);
    }
}
