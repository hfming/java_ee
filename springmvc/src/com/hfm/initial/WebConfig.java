package com.hfm.initial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.Properties;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-10-18 18:36
 * @Description
 * 1、扫描组件2、视图解析器3，view-controller 4，default-servlet-handler
 * 5、mvc注解驱动6、文件上传解析器7，异常处理8、拦截器
 * @date 2021/10/18
 */
@Configuration
// 扫描组件
@ComponentScan("com.hfm")
// 开启MVC注解驱动
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    // 使用默认的servlet处理静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 配置文件上传解析器
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

    //配置拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        FirstInterceptor firstInterceptor = new FirstInterceptor();
//        registry.addInterceptor(firstInterceptor).addPathPatterns("/**");
//    }

    // 配置视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    // 配置异常映射
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.ArithmeticException", "error");
        //设置异常映射
        exceptionResolver.setExceptionMappings(prop);
        //设置共享异常信息的键
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);
    }

    //  配置生成模板解析器
//    @Bean
//    public ITemplateResolver templateResolver() {
//        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过WebApplicationContext 的方法获得
//        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
//                webApplicationContext.getServletContext());
//        templateResolver.setPrefix("/WEB-INF/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("UTF-8");
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        return templateResolver;
//    }
//
//    //生成模板引擎并为模板引擎注入模板解析器
//    @Bean
//    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//        return templateEngine;
//    }
//
//    //生成视图解析器并未解析器注入模板引擎
//    @Bean
//    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setCharacterEncoding("UTF-8");
//        viewResolver.setTemplateEngine(templateEngine);
//        return viewResolver;
//    }
}