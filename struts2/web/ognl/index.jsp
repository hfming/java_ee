<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OGNL 与值栈</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/valueStack_get.action?name=hfm">获取值栈对象</a><br/>
    <a href="${pageContext.request.contextPath}/valueStack_insert1.action?name=hfm">对象栈存储数据方式一:调用值栈对象的 set 方法</a><br/>
    <a href="${pageContext.request.contextPath}/valueStack_insert2.action?name=hfm">对象栈存储数据方式二:调用值栈对象的 push方法</a><br/>
    <a href="${pageContext.request.contextPath}/valueStack_insert3.action?name=hfm">对象栈存储数据方式三:在 action 定义变量，生成变量的 get 方法</a><br/>
    <a href="${pageContext.request.contextPath}/valueStack_insertObject.action">对象栈存储对象</a><br/>
    <a href="${pageContext.request.contextPath}/valueStack_insertList.action">对象栈存储对象</a><br/>
    <a href="${pageContext.request.contextPath}/valueStack_getString.action?username=hfm">获取对象栈中的字符串</a><br/>
    <a href="${pageContext.request.contextPath}/valueStack_getObject.action?name=hfm&password=17111711">获取对象栈中的对象</a><br/>
    <a href="${pageContext.request.contextPath}/valueStack_getMyList.action">获取对象栈中的 list 集合</a><br/>
</body>
</html>
