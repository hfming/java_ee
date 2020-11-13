package com.hfm.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.mgt.SecurityManager; // 需要手动导入

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-18 15:46
 * @Description
 * @date 2020/10/18
 */
public class ShiroDemo {
    private static final transient Logger log = LoggerFactory.getLogger(ShiroDemo.class);

    public static void main(String[] args) {
        //  创建具有已配置的领域、用户、角色和权限的Shiro SecurityManager的最简单方法是使用简单的INI配置。
        //  我们将通过使用一个工厂，它可以摄取一个。ini文件并返回一个SecurityManager实例:在类路径的根使用shiro.ini文件(文件:和url:前缀分别从文件和url加载):
        // 读取配置文件，初始化shiroManger工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //工厂模式,获得securityManager实例对象

        SecurityManager securityManager = factory.getInstance();

        // 对于这个简单的示例《快速入门》，创建SecurityManager可以作为JVM单例访问。
        // 大多数应用程序不会这样做而依赖于它们的容器配置或web.xml webapps。
        // 这超出了这个简单的快速入门的范围我们只做最小值，这样你们就能继续得到一些感觉。
        //将securityManger实例绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);

        // 现在已经设置了一个简单的Shiro环境，让我们看看您可以做些什么:获取当前执行的用户:
        // 获取当前的 Subject. 调用 SecurityUtils.getSubject();
        Subject currentUser = SecurityUtils.getSubject();

        // 使用会话做一些事情(不需要web或EJB容器!!)
        // 测试使用 Session
        // 获取 Session: Subject#getSession()
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("---> Retrieved the correct value! [" + value + "]");
        }

        // 让我们登录当前用户，这样我们可以检查角色和权限:
        // 测试当前的用户是否已经被认证. 即是否已经登录.
        // 调动 Subject 的 isAuthenticated()
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            // rememberme
            token.setRememberMe(true);
            try {
                // 执行登录.
                currentUser.login(token);
            }
            // 若没有指定的账户, 则 shiro 将会抛出 UnknownAccountException 异常.
            catch (UnknownAccountException uae) {
                log.info("----> There is no user with username of " + token.getPrincipal());
                return;
            }
            // 若账户存在, 但密码不匹配, 则 shiro 会抛出 IncorrectCredentialsException 异常。
            catch (IncorrectCredentialsException ice) {
                log.info("----> Password for account " + token.getPrincipal() + " was incorrect!");
                return;
            }
            // 用户被锁定的异常 LockedAccountException
            catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // 这里捕获更多异常(可能是特定于您的应用程序的自定义异常?
            // 所有认证时异常的父类.
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //print their identifying principal (in this case, a username):
        log.info("----> User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role:
        // 测试是否有某一个角色. 调用 Subject 的 hasRole 方法.
        if (currentUser.hasRole("schwartz")) {
            log.info("----> May the Schwartz be with you!");
        } else {
            log.info("----> Hello, mere mortal.");
            return;
        }

        //test a typed permission (not instance-level)
        // 测试用户是否具备某一个行为. 调用 Subject 的 isPermitted() 方法。
        if (currentUser.isPermitted("lightsaber:weild")) {
            log.info("----> You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        // 测试用户是否具备某一个行为.
        if (currentUser.isPermitted("user:delete:zhangsan")) {
            log.info("----> You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //all done - log out!
        // 执行登出. 调用 Subject 的 Logout() 方法.
        System.out.println("---->" + currentUser.isAuthenticated());

        currentUser.logout();

        System.out.println("---->" + currentUser.isAuthenticated());

        System.exit(0);
    }
}
