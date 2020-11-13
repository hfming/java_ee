<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OGNL 表达式</title>
</head>
<body>
<%-- OGNL 需要与 struts2 标签一起使用--%>
    <s:property value="'AACCDD'.length()"></s:property><br/>
</body>
</html>
