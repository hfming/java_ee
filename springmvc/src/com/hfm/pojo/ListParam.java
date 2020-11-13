package com.hfm.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-05 21:49
 * @Description
 * @date 2020/10/5
 */
public class ListParam implements Serializable {
    /**
     * String 数组
     */
    private String[] strings;
    /**
     * 对象数组
     */
    private User[] users;
    /**
     * String list 集合
     */
    private List<String> stringList;
    /**
     * 对象 List 集合
     */
    private List<User> userList;
//    /**
//     * String set 集合
//     */
//    private Set<String> stringSet;
//    /**
//     * Object set 集合
//     */
//    private Set<User> userSet;
    /**
     * String map 集合
     */
    private Map<Integer, String> stringMap;
    /**
     * 对象 map 集合
     */
    private Map<Integer, User> userMap;

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Map<Integer, String> getStringMap() {
        return stringMap;
    }

    public void setStringMap(Map<Integer, String> stringMap) {
        this.stringMap = stringMap;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }
}
