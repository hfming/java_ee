package com.hfm.domain.condition;

import com.hfm.domain.CRUDUser;

import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-22 19:20
 * @Description
 * @date 2020/10/22
 */
public class CRUDUserCondition {
    private CRUDUser user;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public CRUDUser getUser() {
        return user;
    }

    public void setUser(CRUDUser user) {
        this.user = user;
    }
}
