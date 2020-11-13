package com.hfm.domain.condition;

import com.hfm.domain.User;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 19:20
 * @Description
 * @date 2020/10/22
 */
public class UserCondition {
    private User user;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
