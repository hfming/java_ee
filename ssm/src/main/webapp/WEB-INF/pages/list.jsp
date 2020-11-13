<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<title>SSM - 查询页面</title>
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
		<!--搭建显示页面-->
		<div class="container">
			<!-- 标题-->
			<div class="row">
				<div class="col-md-12">
					<h1>SSM - CRUD</h1>
				</div>
			</div>
			<!-- 按钮-->
			<div class="row col-md-3 col-md-offset-9 col-lg-offset-9">
				<button type="button" class="btn btn-primary">
						<span class="glyphicon glyphicon-plus" aria-hidden="true">新增</span>
						</button>
				<button type="button" class="btn btn-danger">
						<span class="glyphicon glyphicon-trash" aria-hidden="true">删除</span>
						</button>
			</div>
			<!-- 表格-->
			<div class="row">
				<div class="col-md-12">
					<table class="table table-hover">
						<thead>
							<caption align="center">查询所有 Employee</caption>
							<tr>
								<th>ID</th>
								<th>lastName</th>
								<th>email</th>
								<th>gender</th>
								<th>deptName</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pageInfo.list}" var="emp">
								<tr>
									<td>${emp.empId}</td>
									<td>${emp.empName}</td>
									<td>${emp.email}</td>
									<td>
										<c:choose>
											<c:when test="${emp.gender == 1}">
												男
											</c:when>
											<c:otherwise>
												女
											</c:otherwise>
										</c:choose>
									</td>
									<td>${emp.dept.deptName}</td>
									<td>
										<button type="button" class="btn btn-warning btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true">修改</span>
                                
                            </button>
										<button type="button" class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true">删除</span>
                            </button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>

						</tfoot>
					</table>
				</div>
			</div>
			<!-- 分页条-->
			<div class="row">
				<!-- 分页信息 -->
				<div class="col-md-7 pagination">
					当前${pageInfo.pageNum},共${pageInfo.pages} 页 / 共${pageInfo.total} 条 ，跳至 <input type="text" />页
				</div>
				<div class="col-md-5">
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-end">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/emp/list?currentPage=1">首页</a>
							</li>

							<c:if test="${pageInfo.hasPreviousPage}">
								<li class="page-item">
									<a class="page-link" href="${pageContext.request.contextPath}/emp/list?currentPage=${pageInfo.prePage}" tabindex="-1" aria-disabled="true">Previous</a>
								</li>
							</c:if>

							<c:forEach items="${pageInfo.navigatepageNums}" var="pageNumer">
								<!-- 判断是否是当前页 -->
								<c:choose>
									<c:when test="${pageNumer == pageInfo.pageNum}">
										<li class="page-item active">
											<a class="page-link" href="${pageContext.request.contextPath}/emp/list?currentPage=${pageNumer}">${pageNumer}</a>
										</li>
									</c:when>
									<c:otherwise>
										<li class="page-item">
											<a class="page-link" href="${pageContext.request.contextPath}/emp/list?currentPage=${pageNumer}">${pageNumer}</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:if test="${pageInfo.hasNextPage}">
								<li class="page-item">
									<a class="page-link" href="${pageContext.request.contextPath}/emp/list?currentPage=${pageInfo.nextPage}">Next</a>
								</li>
							</c:if>

							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/emp/list?currentPage=${pageInfo.pages}">末页</a>
							</li>
						</ul>
					</nav>

				</div>

			</div>
		</div>
	</body>

</html>