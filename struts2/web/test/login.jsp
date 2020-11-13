<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    在线登录人数：${num == null ? 0:num}<br/>
    <form action="login.action" method="post">
        用户名：<input type="text" placeholder="请输入用户名" name="name"><br/>
        密码：<input type="password" placeholder="请输入密码" name="password"><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
