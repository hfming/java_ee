package com.hfm.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-14 21:26
 * @Description
 * @date 2020/10/14
 */
@Configurable
@ComponentScan(value = {"com.hfm.aware"})
public class FirstConfigure {
}
