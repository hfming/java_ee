package com.hfm.filter;

import com.hfm.pojo.Product;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-17 13:52
 * @Description Filter 过滤器作为 MVC 控制器
 * @date 2020/9/17
 */
//@WebFilter(filterName = "FilterDispatcher", urlPatterns = "*.action") // 拦截所有 action
public class FilterDispatcher implements Filter {
    @Override
    public void destroy() {
        System.out.println("Filter 过滤器 - 销毁");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 转换成 HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setContentType("text/html;charset=UTF-8");

        String path = "";

        // 如果 ServletPath 匹配
        if ("/test/product-input.action".equalsIgnoreCase(request.getServletPath())) {
            path = "/test/finput.jsp";
        }

        if ("/test/product-save.action".equalsIgnoreCase(request.getServletPath())) {
            // 获取参数
            String productName = request.getParameter("productName");
            String productDesc = request.getParameter("productDesc");
            double productPrice = Double.parseDouble((String) request.getParameter("productPrice"));

            Product product = new Product(null, productName, productDesc, productPrice);
            // 存储到 request 域中
            request.setAttribute("product", product);

            path = "/test/fdetails.jsp";
        }

        // 跳转路径打印
        System.out.println(path);

        if (path != null) {
            // 请求转发,跳转到 path 指定路径
            request.getRequestDispatcher(path).forward(request, response);
            return;
        }
        // 放行
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter 过滤器 - 启动");
    }
}
