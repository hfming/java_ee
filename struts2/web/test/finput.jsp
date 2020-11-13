<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输入页面</title>
</head>
<body>
    <form action="product-save.action" method="post">
        ProductName:<input type="text" name="productName">
        <br/><br/>
        ProductDesc:<input type="text" name="productDesc">
        <br/><br/>
        ProductPrice:<input type="number" name="productPrice">
        <br/><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
