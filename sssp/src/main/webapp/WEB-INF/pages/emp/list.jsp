<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工表</title>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<h4>Employee List Page</h4>
<c:choose>
    <c:when test="${page  == null || page.numberOfElements  == 0}">
        没有任何员工信息
    </c:when>
    <c:otherwise>
        <table border="1" cellpadding="10" cellspacing="1">
            <tr>
                <td>ID</td>
                <td>LASTNAME</td>
                <td>EMAIL</td>
                <td>BIRTH</td>
                <td>CREATETIME</td>
                <td>DEPT</td>
                <td>DELETE</td>
                <td>EDIT</td>
            </tr>
            <c:forEach items="${page.content}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.email}</td>
                    <td>
                        <fmt:formatDate value="${employee.birth}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>
                        <fmt:formatDate value="${employee.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
                    </td>
                    <td>${employee.department.departmentName}</td>
                    <td>
                        <a href="employee/delete?id=${employee.id}" class="delete">Delete</a>
                    </td>
                    <td>
                        <a href="employee?id=${employee.id}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    共 ${page.totalElements} 条记录
                    共 ${page.totalPages} 页
                    当前 ${page.number + 1} 页
                    <a href="?pageNo=${page.number + 1 - 1 }">上一页</a>
                    <a href="?pageNo=${page.number + 1 + 1 }">下一页</a>
                </td>
            </tr>
        </table>
    </c:otherwise>
</c:choose>
</body>
<script type="text/javascript">
    $(function () {
        //1. 点击 delete 时, 弹出 确定是要删除 xx 的信息吗 ? 若确定, 执行删除, 若不确定, 则取消
        $(".delete").click(function () {
            var lastName = $(this).next(":hidden").val();
            var flag = confirm("确定要删除" + lastName + "的信息吗?");
            if (flag) {
                var $tr = $(this).parent().parent();
                //删除, 使用 ajax 的方式
                var url = this.href;
                var args = {"time": new Date()};
                $.post(url, args, function (data) {
                    //若 data 的返回值为 1, 则提示 删除成功, 且把当前行删除
                    if (data == "1") {
                        alert("删除成功!");
                        $tr.remove();
                    } else {
                        //若 data 的返回值不是 1, 提示删除失败.
                        alert("删除失败!");
                    }
                });
            }
            //取消超链接的默认行为
            return false;
        });
    })
</script>
</html>