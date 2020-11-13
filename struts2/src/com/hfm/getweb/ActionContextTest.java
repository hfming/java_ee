package com.hfm.getweb;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-17 20:25
 * @Description 通过 ActionContext 获取 web 资源
 * @date 2020/9/17
 */
public class ActionContextTest extends ActionSupport {
    public String test() {
        // 获取 AcctionContext 实现类对象
        ActionContext context = ActionContext.getContext();

        // 通过调用 AcctionContext 对象的 getXXX 方法获取 web 资源
        // 获取 ServerContext 域存储的数据 map 集合
        Map<String, Object> application = context.getApplication();
        application.put("applicationTest", "Application");

        // 获取 session 域存储的数据 map 集合
        Map<String, Object> session = context.getSession();
        session.put("sessionTest", "Session");

        // 不能直接获取 request 域的参数集合 ，应该从 Context中获取
        // 先通过 ActionContext 的 getContextMap 获取 ContextMap(Map 栈), map 栈中存储各个域对象的对应的 Map 集合的引用
        // 因此可以通过 ContextMap 的 get 方法获取到 Request 对应的 Map 集合
        // 之后就可以对 RequestMap 集合进行操作
        Map<String, Object> request = (Map<String, Object>) context.getContextMap().get("request");
        request.put("requestTest", "Request");

        // 获取请求参数
        // getParameters 方式返回  Map<String, Object>,而不是   Map<String, String[]>
        // parameters 只能获取数据,不能存储数据
        Map<String, Object> parameters = context.getParameters();

        // 打印初始
        for (Map.Entry<String, Object> stringObjectEntry : parameters.entrySet()) {
            System.out.println(stringObjectEntry.getKey());
            // 值是 String 数组需要进行数据类型转换,并且取数组第一个元素
            System.out.println(((String[]) stringObjectEntry.getValue())[0]);
        }

        return "test";
    }
}
