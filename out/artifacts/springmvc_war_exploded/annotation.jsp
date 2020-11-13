<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC 常用注解</title>
</head>
<body>
    <a href="annotation/requestParamTest?name=hfm&ps=17111711">RequestParam 注解测试</a><br/>

    <!-- request body注解 -->
    <form action="annotation/requestBodyTest" method="post">
        用户名称：<input type="text" name="username" ><br/>
        用户密码：<input type="password" name="password" ><br/>
        用户年龄：<input type="text" name="age" ><br/>
        <input type="submit">
    </form>

    <a href="annotation/requestBodyTest?body=test">requestBody 注解 get 请求</a><br/>

    <!-- PathVariable注解 -->
    <a href="annotation/pathVariableTest/100">pathVariable注解1</a><br/>
    <form action="annotation/pathVariableTest/200" method="post">
        <input type="submit" value="pathVariable注解2">
    </form>

    <a href="annotation/requestHeaderTest">@RequestHeader 注解</a><br/>

    <a href="annotation/cookieValueTest">@CookieValue 注解测试</a><br/>

    <a href="annotation/modelAttributeTest">@ModelAttribute  注解测试</a><br/>
    <a href="annotation/modelAttributeTest?username=ptt">@ModelAttribute  注解测试 注解方法有返回值</a><br/>
    <a href="annotation/modelAttributeTest?username=ptt">@ModelAttribute  注解测试 注解方法没有返回值</a><br/>


    <!-- SessionAttribute注解的使用 -->
    <a href="annotation/sessionAttributePutTest">存入 SessionAttribute</a><br/>
    <a href="annotation/sessionAttributeGetTest">取出 SessionAttribute</a><br/>
    <a href="annotation/sessionAttributeCleanTest">清除 SessionAttribute</a><br/>



</body>
</html>
