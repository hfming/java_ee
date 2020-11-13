<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<h4>Employee Input Page</h4>
<form action="${pageContext.servletContext.contextPath}/employee/saveAndUpdate" method="post">
    <c:choose>
        <c:when test="${employee != null}">
            LastName:<input type="text" name="lastName" disabled="true" id="lastName" value="${employee.lastName}"><br/>
            Email:<input type="text" name="email" value="${employee.email}"><br/>
            Birth:<input type="text" name="birth" value="${employee.birth}"><br/>
            <input type="hidden" name="id" value="${employee.id}"><br/>
        </c:when>
        <c:otherwise>
            LastName:<input type="text" name="lastName" id="lastName"><br/>
            Email:<input type="text" name="email"><br/>
            Birth:<input type="text" name="birth"><br/>
        </c:otherwise>
    </c:choose>

    <select name="demartmentName">
        <c:forEach items="${departments}" var="department">
            <option value="${department.departmentName}" id="${department.id}">${department.departmentName}</option>
        </c:forEach>
    </select><br/>

    <input type="submit">
</form>
</body>
<script type="text/javascript">
    $("#lastName").blur(function () {
        // 获取用户名
        var val = $(this).val();
        val = $.trim(val);
        var $this = $(this);
        if (val !== "") {
            //把当前节点后面的所有 font 兄弟节点删除
            $this.nextAll("font").remove();
            $.post(
                "${pageContext.servletContext.contextPath}/nameExited",
                {
                    "lastName": val,
                },
                function (data) {
                    //表示可用
                    if (data === false) {
                        $this.after("<font color='green'>LastName可用!</font>");
                    }
                    //不可用
                    else if (data === true) {
                        $this.after("<font color='red'>LastName不可用!</font>");
                    }
                    //服务器错误
                    else {
                        alert("服务器错误!");
                    }
                },
                "JSON"
            );
        } else {
            alert("lastName 不能为空");
            $(this).val("");
            $this.focus();
        }
    });
</script>
</html>