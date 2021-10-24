<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Struts2 数据封装</title>
</head>
<body>
    <a href="OriginalWay.action?name=hfm&password=11711711">原始方式</a><br/>
    <a href="PropertyWay.action?name=hfm&password=11711711">属性驱动</a><br/>
    <a href="ModelDrivenWay.action?name=hfm&password=11711711">原型驱动</a><br/>
    <a href="ExpressionWay.action?user.name=hfm&user.password=1171117">表达式封装</a><br/>

    <form action="getList.action" method="post" >
        User1 name<input type="text" name="users[0].name"><br/>
        User1 password<input type="text" name="users[0].password"><br/>
        User2 name<input type="text" name="users[1].name"><br/>
        User2 password<input type="text" name="users[1].password"><br/>

        <input type="submit" value="提交"><br/>
    </form>
</body>
</html>
