<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shiro 标签</title>
</head>
<body>
<%--如果当前Subject 有角色将显示body 体内容--%>
    <shiro:hasRole name="user">

    </shiro:hasRole>

</body>
</html>
