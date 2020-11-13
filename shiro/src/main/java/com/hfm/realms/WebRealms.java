package com.hfm.realms;

import com.hfm.domain.User;
import com.hfm.server.UserServer;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-19 11:22
 * @Description
 * @date 2020/10/19
 */
public class WebRealms extends AuthenticatingRealm {
    @Autowired
    private UserServer userServer;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println(authenticationToken);

        // 将 AuthenticationToken 转化未 UsernamePasswordToken 对象
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        // 获取 UsernamePasswordToken 中存储的数据
        String username = token.getUsername();
        String password = new String(token.getPassword());

        // 调用 Server 层进行验证
        User login = userServer.login(username, password);

        // 用户不存在，爬出 UnknowAccountException 异常
        if (login == null) {
            throw new UnknownAccountException("用户不存在");
        }
        // 用户存在，根据用户的情况，决定是否需要抛出其他的 AuthenticationException 异常
//        if ("moster".equalsIgnoreCase(username)) {
//            throw new LockedAccountException("用户被锁定");
//        }

        // 也可以根据用户对象创建 AuthenticationInfo 并返回
        // principal 认证的实体学习，可以是 username ，也可以是数据表对象的用户实体类
        Object principal = username;

        // 当前 realms 对应的名称，调用父类的 getName() 方法即可
        String realmName = this.getName();

        // 盐值加密
        ByteSource salt = ByteSource.Util.bytes(username);

        // credentials 密码
        // 如果前端使用了加密算法，此处传入的值也应该是经过加密算法计算之后的值
        SimpleHash md5 = new SimpleHash("MD5", password, salt, 1024);
        Object credentials = md5;

        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, credentials,salt, realmName);
        return authenticationInfo;
    }
}
