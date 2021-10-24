package com.hfm.valuestrack;

import com.hfm.pojo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.CompoundRoot;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-19 7:51
 * @Description
 * @date 2020/9/19
 */
public class ValueStrack extends ActionSupport implements ModelDriven<User> {
    /**
     * 获取值栈、对象栈、Map 栈对象
     *
     * @return
     */
    public String get() {
        // 通过 ActionContext 对象获取 值栈对象
        ActionContext context = ActionContext.getContext();

        // 获取值栈对象
        ValueStack valueStack = context.getValueStack();
        ValueStack valueStack2 = context.getValueStack();
        System.out.println(valueStack2 == valueStack);
        // 打印值值栈
        System.out.println(valueStack);

        // 获取对象栈
        CompoundRoot root = valueStack.getRoot();
        System.out.println(root);

        // 获取 Map 栈
        Map<String, Object> contextMap = valueStack.getContext();
        System.out.println(contextMap);
        return "get";
    }


    /**
     * 对象栈存储数据
     * 方式 一
     * 调用值栈对象的 set 方法
     *
     * @return
     */
    public String insert1() {
        ValueStack valueStack = ActionContext.getContext().getValueStack();

        // 1.set 方法存储数据,存储在对象栈中
        valueStack.set("test", "set");
        return "insert1";
    }

    /**
     * 对象栈存储数据
     * 方式 二
     * 调用值栈对象的 push方法
     *
     * @return
     */
    public String insert2() {
        ValueStack valueStack = ActionContext.getContext().getValueStack();

        // 2.push 方法存储数据,存储在对象栈中
        valueStack.push("push");

        return "insert2";
    }

    /**
     * 成员变量
     */
    private String name;

    /**
     * get方法
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 值栈存储数据
     * 方式 三
     * 在action定义变量，生成变量的get方法
     *
     * @return
     */
    public String insert3() {
        ValueStack valueStack = ActionContext.getContext().getValueStack();

        // 3.成员变量及其 get 方法,直接存储在 action 值栈中
        this.name = "值栈存储数据的第三种方法";
        return "insert3";
    }

    /**
     * 通过模型驱动自动封装数据
     */
    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 获取对象栈中的对象
     *
     * @return
     */
    public String getObject() {
        return "getObject";
    }

    @Override
    public User getModel() {
        return user;
    }

    /**
     * 对象栈 插入对象
     *
     * @return
     */
    public String insertObject() {
        user.setName("hfm");
        user.setPassword("17111711");

        return "insertObject";
    }

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * 对象栈 获取 list 集合
     *
     * @return
     */
    public String getMyList() {
        User hfm = new User("hfm", "17111711");
        User pdd = new User("pdd", "dpp1234");

        this.users.add(hfm);
        this.users.add(pdd);

        System.out.println(users);
        return "getMyList";
    }

    /**
     * 对象栈 存储集合
     *
     * @return
     */
    public String insertList() {
        User hfm = new User("hfm", "17111711");
        User pdd = new User("pdd", "dpp1234");

        this.users.add(hfm);
        this.users.add(pdd);

        return "insertList";
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 对象栈 获取 String 数据
     *
     * @return
     */
    public String getString() {
        return "getString";
    }
}
