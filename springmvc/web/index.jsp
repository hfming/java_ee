<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SpringMvc 入门</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/hello" >Spring mvc 入门</a><br/>

  <a href="${pageContext.request.contextPath}/account/add" >模块化开发第一种方式</a><br/>
  <%--  当我们使用此种方式配置时，在jsp中第二种写法时，不要在访问URL前面加/，否则无法找到资源--%>
  <a href="account/add">模块化开发第二种方式</a><br/>

  <a href="propertyTest/post">@RequestMapping method 属性 post 方法</a><br/>
  <a href="propertyTest/get">@RequestMapping method 属性 get 方法</a><br/>

  <a href="propertyTest/params?name=hfm&money=100">@RequestMapping params 属性1</a><br/>
  <a href="propertyTest/params?name=hfm&money=90">@RequestMapping params 属性2</a><br/>
  <a href="propertyTest/params?money=100">@RequestMapping params 属性3</a><br/>
  <a href="propertyTest/params?money=120">@RequestMapping params 属性4</a><br/>

  <a href="propertyTest/headers">@RequestMapping Headers 属性</a><br/>
  <form action="/propertyTest/headers" method="post">
    <input type="submit">
  </form>
  <hr/>
  <a href="params/paramsTest?username=hfm&password=17111711">请求参数的绑定</a><br/>
  <a href="params/paramsBase?username=hfm&number=112&flag=true&character=a&adouble=3.14">请求参数的绑定 基本数据类型</a><br/>
  <a href="params/paramsObject?username=中文&password=17111711">请求参数的绑定 对象数据类型</a><br/>
  <a href="params/paramsObjectProp?user.username=中文&user.password=17111711">请求参数的绑定 对象数据中的对象类型属性</a><br/>

  <form action="params/paramsListProp" method="post">
    strings <input type="text" name="strings[0]"><br/>
    strings <input type="text" name="strings[1]"><br/>
    users username<input type="text" name="users[0].username"><br/>
    users password<input type="text" name="users[0].password"><br/>
    users username<input type="text" name="users[1].username"><br/>
    users password<input type="text" name="users[1].password"><br/>
    stringList <input type="text" name="stringList[0]"><br/>
    stringList <input type="text" name="stringList[1]"><br/>
    userList username<input type="text" name="userList[0].username"><br/>
    userList password<input type="text" name="userList[0].password"><br/>
    userList username<input type="text" name="userList[1].username"><br/>
    userList password<input type="text" name="userList[1].password"><br/>
<%--    stringSet<input type="text" name="stringSet[0]"><br/>--%>
<%--    stringSet<input type="text" name="stringSet[1]"><br/>--%>
<%--    userSet username<input type="text" name="userSet[0].username"><br/>--%>
<%--    userSet password<input type="text" name="userSet[0].password"><br/>--%>
<%--    userSet username<input type="text" name="userSet[1].username"><br/>--%>
<%--    userSet password<input type="text" name="userSet[1].password"><br/>--%>
    stringMap <input type="text" name="stringMap['1']"><br/>
    stringMap <input type="text" name="stringMap['2']"><br/>
    userMap username<input type="text" name="userMap['1'].username"><br/>
    userMap password<input type="text" name="userMap['1'].password"><br/>
    userMap username<input type="text" name="userMap['2'].username"><br/>
    userMap password<input type="text" name="userMap['2'].password"><br/>
    <input type="submit">
  </form>

  <a href="params/paramsList?users[0].username=hfm&users[0].password=17111711&users[1].username=hfm&users[1].password=17111711">
    请求参数的绑定 集合数据类型
  </a><br/>

  <a href="params/paramsDate?date=2020-10-06 11:09:23">自定义数据类型转换器 String 类型转换为 Data 类型</a><br/>
  <a href="params/parmasServletAPI">原生 API</a><br/>
  </body>
</html>
