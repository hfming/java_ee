package com.hfm.linster; /**
 * @Description
 * @author hfming2016@163.com
 * @version 1.01 2020-09-22 20:52
 * @date 2020/9/22
 */

import com.hfm.util.HibernateUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class FirstListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // SessionFactory 在 web 应用启动时就创建
        HibernateUtils.getSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
