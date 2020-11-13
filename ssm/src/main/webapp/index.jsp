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
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" id="addModalBt">
            <span class="glyphicon glyphicon-plus" aria-hidden="true">新增</span>
        </button>
				<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" id="dleteAllBt">
            <span class="glyphicon glyphicon-trash" aria-hidden="true">删除全部</span>
        </button>
			</div>

			<%-- 添加对话框 --%>
			<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">添加 Employee</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form class="form-horizontal" id="addForm">
								<div class="form-group">
									<label for="empName_input" class="col-sm-2 control-label">员工姓名</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="empName_input" placeholder="请输入用户名" name="empName">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">性别</label>
									<label class="radio-inline">
										<input type="radio" id="inlineRadio1" value="1" name="gender" class="gender" checked> 男
									</label>
									<label class="radio-inline">
										<input type="radio" id="inlineRadio2" value="0" name="gender" class="gender"> 女
									</label>
								</div>
								<div class="form-group">
									<label for="email_input" class="col-sm-2 control-label">邮箱号</label>
									<div class="col-sm-8">
										<input type="email" class="form-control" id="email_input" placeholder="请输入邮箱号" name="email">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">所在部门</label>
									<div class="col-sm-4">
										<select class="form-control" id="deptSelect" name="deptId">
										</select>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary" id="submit">提交</button>
						</div>
					</div>
				</div>
			</div>

			<script type="text/javascript">
				$("#addModalBt").click(function() {
					// 重置表单数据
					$("#addForm")[0].reset();
					// 重置表单样式
					$("#addForm").find("*").removeClass("has-error has-success");
					$("#addForm").find(".help-block").text("");
					getDepts("#deptSelect");
				});

				function getDepts(element) {
					// 加载所有部门名
					$.post(
						"${pageContext.request.contextPath}/depts", {

						},
						function(depts) {
							var select = $(element).empty();
							$.each(depts, function(index, item) {
								select.append($("<option value='" + item.deptId + "'></option>").append(item.deptName));
							})
						},
						"json"
					)
				}

				// 提交表单数据
				$("#submit").click(function() {
					// 姓名是否已经存在，如果存在则不能提交表单
					if(regNameAndEmail()) {
						$.post(
							"${pageContext.request.contextPath}/emp",
							$("#addForm").serialize(),
							function(empId) {
								if(empId != null) {
									alert("添加成功！")
								} else {
									alert("添加失败！")
								}

								// 关闭对话框
								$("#addModal").modal("hide");

								// 跳转到最后一页查看数据
								getPage(empId)
							},
							"json"
						)
						return true;
					}
					return false;
				})
				//	 用户名与邮箱号校验
				function regNameAndEmail() {
					var regNameAndEmail = true;
					var empName = $("#empName_input").val();
					var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
					$("#empName_input").parent().children(".help-block").remove()

					if(!regName.test(empName)) {
						$("#empName_input").parent().addClass("has-error")
						$("#empName_input").parent().append($("<span></span>").addClass("help-block").append("员工名格式错误！"))
						regNameAndEmail = false;
					} else {
						// 清空旧样式添加新样式
						$("#empName_input").parent().removeClass("has-error").addClass("has-success");
						// 员工姓名是否存在
						if(checkName("#empName_input")) {
							regNameAndEmail = false;
						}
					}

					var email = $("#email_input").val();
					var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
					$("#email_input").parent().children(".help-block").remove()
					if(!regEmail.test(email)) {
						$("#email_input").parent().addClass("has-error")
						$("#email_input").parent().append($("<span></span>").addClass("help-block").append("邮箱格式错误！"))
						alert("邮箱格式错误！" + false)
						regNameAndEmail = false;
					} else {
						$("#email_input").parent().removeClass("has-error").addClass("has-success");
					}

					return regNameAndEmail;
				}

				// 离焦事件，ajax 校验用户名
				$("#empName_input").change(function() {
					checkName("#empName_input");
				})

				// 校验用户名，如果存在 false,如果不存在 true
				function checkName(element) {
					var empName = $(element).val();

					var bool = true;
					$.ajax({
						cache: true,
						type: "POST",
						url: "${pageContext.request.contextPath}/checkName",
						data: {
							"empName": empName
						},
						async: false, // 同步请求
						error: function(request) {
							parent.layer.alert("Connection error");
						},
						success: function(flag) {
							$(element).parent().children(".help-block").remove()
							if(flag) {
								$(element).parent().addClass("has-error")
								$(element).parent().append($("<span></span>").addClass("help-block").append("员工名已存在，请重新输入！"))
							} else {
								$(element).parent().removeClass("has-error").addClass("has-success");
							}
							bool = flag;
						}
					});
					return bool;
				}
			</script>

			<%-- 修改对话框 --%>
			<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">修改 Employee</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form class="form-horizontal" id="updateForm">
								<div class="form-group">
									<label for="empName_input" class="col-sm-2 control-label">员工 ID</label>
									<div class="col-sm-8">
										<input type="text" class="form-control disabled" id="emp_id_update" name="empId" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label for="empName_input" class="col-sm-2 control-label">员工姓名</label>
									<div class="col-sm-8">
										<input type="text" class="form-control disabled" id="emp_name_update" name="empName" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">性别</label>
									<label class="radio-inline">
										<input type="radio" value="1" name="gender" class="gender" checked> 男
									</label>
									<label class="radio-inline">
										<input type="radio" value="0" name="gender" class="gender"> 女
									</label>
								</div>
								<div class="form-group">
									<label for="email_input" class="col-sm-2 control-label">邮箱号</label>
									<div class="col-sm-8">
										<input type="email" class="form-control" id="email_update" placeholder="请输入邮箱号" name="email">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">所在部门</label>
									<div class="col-sm-4">
										<select class="form-control" id="update_deptSelect" name="deptId">
										</select>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary" id="update_submit">更新</button>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				// 绑定单击事件
				$(document).on("click", ".deitbt", function() {
					// 重置表单数据
					$("#updateForm")[0].reset();
					// 重置表单样式
					$("#updateForm").find("*").removeClass("has-error has-success");
					$("#updateForm").find(".help-block").text("");

					// 查询员工与部门数据
					getDepts("#update_deptSelect");

					// 员工数据
					$.get(
						"${pageContext.request.contextPath}/emp/" + $(this).attr("edit-id"), {

						},
						function(emp) {
							$("#emp_id_update").val(emp.empId);
							$("#emp_name_update").val(emp.empName);
							$("#email_update").val(emp.email);

							$("#updateModal input[type=radio]").val([emp.gender])
							$("#updateModal select").val([emp.dept.deptId]);
						},
						"json"
					)
					// 传递 id 值
					$("#update_submit").attr("edit-id", $(this).attr("edit-id"));
				})
				// 提交表单数据
				$("#update_submit").click(function() {
					// 邮箱验证是否成功
					if(regEmail()) {
						$.ajax({
							cache: true,
							type: "POST",
							url: "${pageContext.request.contextPath}/emp/update",
							data: $("#updateForm").serialize(),
							async: false, // 同步请求
							error: function(request) {
								parent.layer.alert("Connection error");
							},
							success: function(flag) {
								if(flag) {
									alert("修改成功")
								} else {
									alert("修改失败")
								}

								// 关系对话框
								$("#updateForm").modal("hide");

								// 跳转到最后一页查看数据
								getPage(pageNumber);
							}
						});
						return true;
					}
					return false;
				})

				function regEmail() {
					var emailFlag = true;
					var email = $("#email_update").val();
					var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
					$("#email_update").parent().children(".help-block").remove()
					if(!regEmail.test(email)) {
						$("#email_update").parent().addClass("has-error")
						$("#email_update").parent().append($("<span></span>").addClass("help-block").append("邮箱格式错误！"))
						alert("邮箱格式错误！" + false)
						emailFlag = false;
					} else {
						$("#email_update").parent().removeClass("has-error").addClass("has-success");
					}
					return emailFlag;
				}
			</script>

			<!-- 表格-->
			<div class="row">
				<div class="col-md-12">
					<table class="table table-hover">
						<thead>
							<center>
								<h2>查询所有 Employee</h2>
							</center>
							<tr>
								<th><input type="checkbox" id="delete_all"></th>
								<th>ID</th>
								<th>lastName</th>
								<th>gender</th>
								<th>email</th>
								<th>deptName</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 分页条-->
			<div class="row">
				<!-- 分页信息 -->
				<div class="col-md-7 col-md-offset-0 pagination" id="pageInfoDiv">
				</div>
				<div class="col-md-5">
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-end" id="pageBarDiv">
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		// 页面加载完成，立即发送 ajax 请求，获取分页数据
		$(function() {
			getPage(1);
		})

		function getPage(currentPage) {
			$.post(
				"${pageContext.request.contextPath}/emps", {
					"currentPage": currentPage
				},
				function(pageInfo) {
					showList(pageInfo);
					showPageBar(pageInfo);
					showPageInfo(pageInfo);
				},
				"json"
			)
		}

		// 显示列表
		function showList(pageInfo) {
			$("tbody").empty();
			var emps = pageInfo.list;
			$.each(emps, function(index, item) {
				var checkBox = $("<td><input type='checkbox' class='check_item'></td>");

				var empID = $("<td></td>").append(item.empId);
				var empName = $("<td></td>").append(item.empName);
				var gender = $("<td></td>").append(item.gender == 1 ? "男" : "女");
				var email = $("<td></td>").append(item.email);
				var deptName = $("<td></td>").append(item.dept.deptName);
				var deitBt = $("<button></button>").addClass("btn btn-warning btn-sm deitbt")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
					.append("修改").attr("edit-id", item.empId).prop("data-target", "#updateModal")
					.prop("data-toggle", "modal")

				var deleteBt = $("<button></button>").addClass("btn btn-danger btn-sm deletebt")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
					.append("删除").attr("delete-id", item.empId);
				$("<tr></tr>")
					.append(checkBox)
					.append(empID)
					.append(empName)
					.append(gender)
					.append(email)
					.append(deptName)
					.append($("<td></td>").append(deitBt).append(" ").append(deleteBt))
					.appendTo("tbody");
			});
		}

		// 显示分页条
		function showPageBar(pageInfo) {
			var ul = $("#pageBarDiv").empty();

			// 首页
			var firstPage = $("<li></li>").addClass("page-item")
				.append($("<a></a>").addClass("page-link").append("首页").attr("href", "#"));

			firstPage.click(function() {
				getPage(1);
			})
			ul.append(firstPage);

			// 前一页
			var prePage = $("<li></li>").addClass("page-item")
				.append($("<a></a>").addClass("page-link").append("Previous").attr("href", "#"));

			prePage.click(function() {
				getPage(pageInfo.pageNum - 1);
			})

			// 如果有前一页
			if(pageInfo.hasPreviousPage) {
				ul.append(prePage);
			}

			$.each(pageInfo.navigatepageNums, function(index, item) {
				var numLi = null;
				if(item == pageInfo.pageNum) {
					numLi = $("<li></li>").addClass("page-item active")
						.append($("<a></a>").addClass("page-link").append(item));
				} else {
					numLi = $("<li></li>").addClass("page-item")
						.append($("<a></a>").addClass("page-link").append(item));
				}
				numLi.click(function() {
					getPage(item);
				})
				ul.append(numLi);
			})

			// 后一页
			var nextPage = $("<li></li>").addClass("page-item")
				.append($("<a></a>").addClass("page-link").append("Next").attr("href", "#"));

			nextPage.click(function() {
				getPage(pageInfo.pageNum + 1);
			})
			// 如果有后一页
			if(pageInfo.hasNextPage) {
				ul.append(nextPage);
			}

			// 末页
			var lastPage = $("<li></li>").addClass("page-item")
				.append($("<a></a>").addClass("page-link").append("末页").attr("href", "#"));

			lastPage.click(function() {
				getPage(pageInfo.pages);
			})
			ul.append(lastPage);
		}

		var pageNumber = 1;
		// 显示分页信息
		function showPageInfo(pageInfo) {
			$("#pageInfoDiv").empty()
				.append("当前第" + pageInfo.pageNum + "页,共" + pageInfo.pages + "页 / 共" + pageInfo.total + "条")
			pageNumber = pageInfo.pageNum;
		}
	</script>

	<script type="text/javascript">
		// 绑定单击事件
		$(document).on("click", ".deletebt", function() {
			if(confirm("确认删除" + $(this).attr("delete-id"))) {
				$.ajax({
					cache: true,
					type: "DELETE",
					url: "${pageContext.request.contextPath}/emp/" + $(this).attr("delete-id"),
					data: "",
					async: false, // 同步请求
					error: function(request) {
						parent.layer.alert("Connection error");
					},
					success: function(flag) {
						if(flag) {
							alert("删除成功")
						} else {
							alert("删除失败")
						}
						getPage(pageNumber);
					}
				})
			}
		});
	</script>

	<script type="text/javascript">
		// 全选，全不选
		$("#delete_all").click(function() {
			// prop 获取原生固有属性
			// attr 获取自定义属性
			$(".check_item").prop("checked", $(this).prop("checked"))
		});

		// $(document).on("click", ".check_item", function () {
		// 	$(".check_item:checked").length === $(".check_item").length ? $(this).prop("checked", true) : $(this).prop("checked",false);
		// });

		// 批量删除
		$("#dleteAllBt").click(function() {
			var ins = new Array();
			var names = "";

			$.each($(".check_item:checked"), function(index, item) {
				var empName = $(this).parents("tr").find("td:eq(2)").text();
				var empId = $(this).parents("tr").find("td:eq(1)").text();
				names += empName + " ";
				ins[index] = empId;
			})
			// 数组转 json
			var json = JSON.stringify(ins);
			if(confirm("确认删除" + names)) {
				$.ajax({
					cache: true,
					contentType: "application/json;charset=UTF-8",
					type: "POST",
					url: "${pageContext.request.contextPath}/emp/batchdelete",
					data: json,
					async: false, // 同步请求
					error: function(request) {
						parent.layer.alert("Connection error");
					},
					success: function(flag) {
						if(flag) {
							alert("删除成功")
						} else {
							alert("删除失败")
						}
						getPage(pageNumber);
					}
				})
			}
		});
	</script>

</html>