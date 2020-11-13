<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<title>首页</title>
		<!-- 先引入加载jquery，再引入bootstrap -->
		<%--    引入 jquery--%>
		<script src="${pageContext.request.contextPath}/scripts/jquery-3.5.1.min.js" type="text/javascript"></script>
		<%--    引入 js --%>
		<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- script标签的type属性和link标签的rel属性必须要加上，这样Bootstrap样式才能生效 -->
		<%--    引入 css--%>
		<link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet">
	</head>

	<body>
	</body>

</html>