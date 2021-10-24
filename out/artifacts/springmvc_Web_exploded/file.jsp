<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传与下载</title>
</head>
<body>
<%--form表单的enctype取值必须是：multipart/form-data (默认值是:application/x-www-form-urlencoded) --%>
<%--enctype:是表单请求正文的类型 --%>
<%--method属性取值必须是Post --%>
<form action="file/upload" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="picname"/><br/>
<%--    提供一个文件选择域<input type=”file” />--%>
    图片：<input type="file" name="uploadFile"/><br/>
    <input type="submit" value="传统方式文件上传"/>
</form>

<form action="file/upload2" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="picname"/><br/>
    <%--    提供一个文件选择域<input type=”file” />--%>
    图片：<input type="file" name="upload"/><br/>
    <input type="submit" value="SpringMVC 方式上传"/>
</form>

<form action="file/upload3" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="picname"/><br/>
    <%--    提供一个文件选择域<input type=”file” />--%>
    图片：<input type="file" name="upload"/><br/>
    <input type="submit" value="SpringMVC 方式上传"/>
</form>
</body>
</html>
