package com.hfm.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-20 12:18
 * @Description 自定义授权 Realm 需要继承 AuthorizingRealm 重写 doGetAuthorizationInfo 与 doGetAuthenticationInfo 方法
 * @date 2020/10/20
 */
public class MyAuthorizationRealm extends AuthorizingRealm {
    /**
     * 授权方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 1.从 PrincipalCollection 中获取用户登录信息
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();

        // 2.利用用户的信息获取用户的角色或权限
        HashSet<String> roles = new HashSet<>();
        roles.add("user");
        if ("admin".equalsIgnoreCase(primaryPrincipal.toString())) {
            roles.add("admin");
        }

        // 3.创建 SimpleAuthenticationInfo 并设置其 roles 属性
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);

        // 4.返回 SimpleAuthenticationInfo 对象
        return simpleAuthorizationInfo;
    }

    /**
     * 认证方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 将 AuthenticationToken 转化未 UsernamePasswordToken 对象
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        // 获取 UsernamePasswordToken 中存储的数据
        String username = token.getUsername();
        String password = new String(token.getPassword());

        Object principal = username;

        // 当前 realms 对应的名称，调用父类的 getName() 方法即可
        String realmName = this.getName();

        // 盐值加密
        ByteSource salt = ByteSource.Util.bytes(username);

        // credentials 密码
        // 如果前端使用了加密算法，此处传入的值也应该是经过加密算法计算之后的值
        SimpleHash md5 = new SimpleHash("MD5", password, salt, 1024);
        Object credentials = md5;

        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, credentials, salt, realmName);
        return authenticationInfo;
    }
}
