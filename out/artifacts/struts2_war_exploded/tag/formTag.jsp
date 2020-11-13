<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Struts2 表单标签</title>
</head>
<body>
<%-- s:form 表单标签 --%>
<%-- Struts2 标签会自动生成table ,进行自动排版--%>
<%-- 表单标签会自动 回显,从栈顶开始匹配属性,将匹配的属性赋值到对应的标签的value 中,如果没有对应的属性,会依次到栈下寻找对应的属性--%>
    <s:debug></s:debug>
    <s:form action="/form_tag.action" method="POST">
        <s:textfield name="username" label="username" ></s:textfield>
<%--        设置密码回显--%>
        <s:password name="password" label="password" showPassword="true"></s:password>
        <s:textarea  name="desc" label="desc"></s:textarea>

<%--        s:checkbox 是单选框,c:checkbox 是对选框--%>
        <s:checkbox name="married" lable="是否结婚"></s:checkbox>

<%--        s:list s:listkey s:listvalue--%>
        <s:select list="{110,112,1212}"></s:select>

        <s:select list="#{'1':'23232', '3':'23223', '4':'34343'}" label="num"></s:select>

        <s:radio list="'非洲','亚洲','美洲'" label="land" name="land"></s:radio>


        <s:submit value="提交"></s:submit>
    </s:form>
</body>
</html>
