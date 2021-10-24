package com.hfm.spring5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-13 18:53
 * @Description
 * @date 2021/10/13
 */
public class UserLog {
    private static final Logger log = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args) {
        log.info("hello log4j2");
        log.warn("hello log4j2");
    }
}
