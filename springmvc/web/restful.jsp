<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>restful</title>
    </head>
    <body>
        <a href="restful/user">查询所有用户</a>
        <!-- 保存 -->
        <form action="restful/user" method="post">
            用户名称：<input type="text" name="username"><br/>
            <input type="hidden" name="_method" value="POST">
            <input type="submit" value="保存">
        </form>
        <hr/>
        <!-- 更新 -->
        <form action="restful/user" method="post">
            用户名称：<input type="text" name="username"><br/>
            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="更新">
        </form>
        <hr/>
        <!-- 删除 -->
        <form action="restful/user/1" method="post">
            <input type="hidden" name="_method" value="DELETE">
            <input type="submit" value="删除">
        </form>
        <hr/>
        <!-- 查询一个 -->
        <a href="restful/user/1">查询一个用户</a>
    </body>
</html>
