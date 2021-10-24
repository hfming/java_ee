<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h4>Employee Input Page</h4>
    <form action="employee_add.action" method="post">
        <lable for="lastName">LastName：</lable>
        <c:if test="${not empty employee.id}">
            <input type="text" name="lastName" value="${employee.lastName}" disabled id="lastName"><br/>
            <input type="hidden" name="id" value="${employee.id}">
        </c:if>
        <c:if test="${empty employee.id}">
            <input type="hidden" name="id" value="${employee.id}" id="lastName"><br/>
        </c:if>
        <lable for="email">Email： </lable>
        <input type="email" name="email" value="${employee.email}" id="email"><br/>
        <lable for="birth">Birth： </lable>
        <input type="birth" name="birth" value="${employee.birth}" id="birth"><br/>
        <lable for="department">DepartMent： </lable>
        <select name="department.id">
            <c:forEach begin="0" end="${departmentsSize}" items="${departments}" var="department">
                <c:if test="${department.id == employee.department.id}">
                    <option value="${department.id}" selected>${department.departmentName}</option>
                </c:if>
                <c:if test="${department.id != employee.department.id}">
                    <option value="${department.id}">${department.departmentName}</option>
                </c:if>
            </c:forEach>
        </select><br/>
        <input type="submit" value="提交">
    </form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("input[name='lastName']").change(function () {
            var val = $(this).val();
            val = $.trim(val);
            var $this = $(this);
            if (val !== "") {
                //把当前节点后面的所有 font 兄弟节点删除
                $this.nextAll("font").remove();
                var url = "${pageContext.request.contextPath}/employee_nameExited.action";
                var args = {"lastName": val};

                $.post(
                    url,
                    args,
                    function (data) {
                        //表示可用
                        if (data == "1") {
                            $this.after("<font color='green'>LastName可用!</font>");
                        }
                        //不可用
                        else {
                            $this.after("<font color='red'>LastName不可用!</font>");
                        }
                    }
                );
            } else {
                alert("lastName 不能为空");
                $(this).val("");
                $this.focus();
            }
        });
    })
</script>
</html>