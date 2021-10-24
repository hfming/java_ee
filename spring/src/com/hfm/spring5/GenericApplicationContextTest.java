package com.hfm.spring5;

import com.hfm.first.User;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-13 18:56
 * @Description
 * @date 2021/10/13
 */
public class GenericApplicationContextTest {

    /**
     * 函数式风格
     */
    @Test
    public void genericApplicationContextTest(){
        //1 创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2 调用context的方法对象注册
        context.refresh();
        context.registerBean("user1", User.class,() -> new User());
        //3 获取在spring注册的对象
        // User user = (User)context.getBean("com.atguigu.spring5.test.User");
        User user = (User)context.getBean("user1");
        System.out.println(user);
    }
}
