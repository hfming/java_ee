package com.hfm.diann;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-29 11:52
 * @Description
 * @date 2020/9/29
 */
@Configurable // 作为配置类,替代 xml 配置文件
@ComponentScan(basePackages = {"com.hfm.diann"}) // 配置组件扫描的路径
public class SpringConfigure {
}
