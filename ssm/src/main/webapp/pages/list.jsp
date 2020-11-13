<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<title>显示所有数据</title>
	</head>

	<body>
		<table align="center" border="1" cellspacing="0px">
			<thead>
				<caption>显示所有数据</caption>
				<tr>
					<th>账户 id</th>
					<th>账户名</th>
					<th>账户余额</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${accounts}" var="accout">
					<tr>
						<td> 账户 id：${accout.id}</td>
						<td> 账户名：${accout.name}</td>
						<td> 账户余额：${accout.money}</td>
						<td>
							<a href="${pageContext.request.contextPath}/account/findById?id=${accout.id}">修改</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/account/delete?id=${accout.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>

</html>