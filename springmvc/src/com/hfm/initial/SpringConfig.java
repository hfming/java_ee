package com.hfm.initial;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-18 18:33
 * @Description
 * @date 2021/10/18
 */
@Configurable // 作为配置类,替代 xml 配置文件
@ComponentScan(basePackages = {"com.hfm"}) // 配置组件扫描的路径
//@Import(value = {JdbcConfig.class})// 导入其他配置类
public class SpringConfig {
}
