<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>值栈</title>
</head>
<body>
    <s:debug></s:debug><br/>
    获取值栈中的字符串:<s:property value="username"/><hr/>
    获取值栈中的对象: <s:property value="user.name"/><br/>
    <s:property value="user.password"/><hr/>

    获取值栈中的 list 集合方式一:
<%--    <s:property value="users.size()"/>&nbsp;--%>
    <s:property value="users[0].name"/>&nbsp;
    <s:property value="users[0].password"/><br/>
    <br/>
    <s:property value="users[1].name"/><br/>
    <s:property value="users[1].password"/><hr/>
    获取值栈中的 list 集合方式二:
    <s:iterator value="users">
        <s:property value="name"/>&nbsp;
        <s:property value="password"/><br/><br/>
    </s:iterator>
    <hr/>
    获取值栈中的 list 集合方式三:
    <s:iterator value="users" var="user">
        <s:property value="#user.name"/>&nbsp;
        <s:property value="#user.password"/><br/><br/>
    </s:iterator>
    <hr/>
</body>
</html>
