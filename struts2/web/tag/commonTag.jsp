<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Struts2 通用标签</title>
</head>
<body>
    s:bebug 标签<s:debug></s:debug><br/>
    s:property 标签:输出一个值栈属性的值<br/>
    对象栈,打印值栈对应的属性值:<s:property value="parametersMap.username[0]"/><br/>
    map 栈,打印 request,session,application 域对象对应的map 中的参数:<s:property value="#parameters.username[0]"/><br/>

    s:url 标签: 创建一个 URL 字符串:
    <s:url value="/test" var="url">
        <s:param name="usernmae" value="2122"></s:param>
    </s:url>
    ${url}<br/>

    <s:url value="/test" var="url2">
<%--        自动进行 ognl 解析--%>
        <s:param name="usernmae" value="#parameters.username[0]"></s:param>
    </s:url>
    ${url2}<br/>

    <s:url value="/test" var="url3">
<%--        不进行 ognl 解析 使用单引号--%>
        <s:param name="usernmae" value="'#parameters.username[0]'"></s:param>
    </s:url>
    ${url3}<br/>

<%--    构建一个请求 action 的地址--%>
    <s:url value="/test" action="common_tag" method="testTag" namespace="/" var="url4">
        <s:param name="usernmae" value="#parameters.username[0]"></s:param>
    </s:url>
    ${url4}<br/>

<%--    设置是否包含请求参数 get 包含get 请求参数 all 包含 post 请求参数 none 不设置请求参数--%>
    <s:url value="/test" includeParams="get"  var="url5"></s:url>
    ${url5}<br/>

    s:set 标签用来在域对象的 Map 对象里创建一个键值对:
<%--    自动对ognl 进行解析--%>
    <s:set name="cpu" value="cpu" scope="page"></s:set>
    ${pageScope.cpu}<br/>

    s:push push 标签将把一个对象压入 ValueStack 而不是压入 ContextMap。
    push 标签在标签起始时把一个对象压入栈, 标签结束时将对象弹出栈。
<%--    <s:push value="String"></s:push><br/>--%>

    s:if s:else s:elseif 标签 类似于 JSTL 的 c:choose c:when c:otherwise
<%--    可以直接使用值栈中的属性--%>
    <s:if test="100>80">

    </s:if>
    <s:elseif test="200 <80">

    </s:elseif>
    <s:else>

    </s:else><br/>

    s:iterator 类似于 c:foreach
    把这个可遍历对象里的每一个元素依次压入和弹出 ValueStack 栈,多用于 list 集合的遍历<br/>

    sort 标签用来对一个可遍历对象里的元素进行排序<br/>

    date 标签用来对 Date 对象进行排版<br/>
    <s:date name="" format="yyyy-MM-dd hh:mm:dd" var="data"></s:date>
</body>
</html>
