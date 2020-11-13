<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<title>首页</title>
	</head>

	<body>
		<c:choose>
			<%-- 没有用户数据显示添加用户--%>
			<c:when test="${account == null}">
				<form action="${pageContext.request.contextPath}/account/add" method="post">
					<table align="center" border="1px" cellspacing="0px">
						<thead>
							<caption>添加用户</caption>
							<tr>
								<th>提交项</th>
								<th>提交数据</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>账户名</td>
								<td><input type="text" name="name"></td>
							</tr>
							<tr>
								<td>账户余额</td>
								<td><input type="text" name="money"></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit">
									<input type="reset">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</c:when>
			<%-- 如果有用户数据则修改用户--%>
			<c:otherwise>
				<form action="${pageContext.request.contextPath}/account/update" method="post">
					<table align="center" border="1px" cellspacing="0px">
						<thead>
							<caption>修改用户</caption>
							<tr>
								<th>修改项</th>
								<th>修改数据</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>账户 id</td>
								<td>${account.id}</td>
							</tr>
							<tr>
								<td>账户名</td>
								<td><input type="text" name="name" value="${account.name}"></td>
							</tr>
							<tr>
								<td>账户余额</td>
								<td><input type="text" name="money" value="${account.money}"></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit">
									<input type="reset">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</c:otherwise>
		</c:choose>

		<hr />
		<center>
			<a href="${pageContext.request.contextPath}/account/findAll">查询所有数据</a>
		</center>

	</body>

</html>