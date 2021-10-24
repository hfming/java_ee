package com.hfm.mytransaction;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 17:07
 * @Description
 * @date 2020/9/29
 */
@Configurable  // 作为配置类,替代 xml 配置文件
@ComponentScan(basePackages = {"com.hfm.mytransaction"}) // 配置组件扫描的路径
@EnableAspectJAutoProxy(proxyTargetClass = true) // 开启生成代理类对象
public class SpringConfig {
}
