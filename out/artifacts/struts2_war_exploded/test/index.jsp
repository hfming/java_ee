<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    <a href="product-input.action">Product Input</a><br/>
    <a href="actionContext-test.action?name=hfm&password=17111711">ActionContext 对象测试</a><br/>
    <a href="servletActionContext-test.action?name=hfm&password=17111711">ServletActionContext 对象测试</a><br/>
    <a href="aware-test.action?name=hfm&password=17111711">Aware 接口测试</a><br/>
    <a href="serletAware-test.action?name=hfm&password=17111711">ServletAware 接口测试</a><br/>
  </body>
</html>
