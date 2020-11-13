package com.hfm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-07 19:47
 * @Description 自定义异常处理器，处理异常
 * @date 2020/10/7
 */
public class MyHandlerException  implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();
        RuntimeException exception = null;
        // 如果抛出的是系统自定义异常则直接转换
        if(e instanceof Exception){
            exception = (RuntimeException) e;
        }else{
        // 如果抛出的不是系统自定义异常则重新构造一个系统错误异常。
            exception = new RuntimeException("系统错误，请与系统管理 员联系！");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fail");
        // 将错误信息放入模型视图
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}
