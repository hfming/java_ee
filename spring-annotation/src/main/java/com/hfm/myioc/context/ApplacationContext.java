package com.hfm.myioc.context;

import com.hfm.myioc.beans.factory.BeanFactory;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-16 11:19
 * @Description
 * @date 2021/10/16
 */
public interface ApplacationContext extends BeanFactory {
    void refresh() throws Exception;
}
