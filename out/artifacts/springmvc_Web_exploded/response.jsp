<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC 响应数据和结果视图 </title>
    <%--    导入 Jquery 文件--%>
    <script src="scripts/jquery-2.1.0.min.js"></script>
</head>
<body>
<a href="response/stringTest?username=hfm&password=17111711">响应数据类型为 String 类型</a><br/>

<a href="response/voidTest1?username=hfm&password=17111711">响应数据类型为 void 无返回值 请求转发</a><br/>
<a href="response/voidTest2?username=hfm&password=17111711">响应数据类型为 void 无返回值 重定向</a><br/>

<a href="response/voidTest3?username=hfm&password=17111711">响应数据类型为 void 无返回值 响应 JSON 数据</a><br/>

<a href="response/modelAndViewTest?username=hfm&password=17111711">响应数据类型为 ModelAndView 类型</a><br/>

<a href="response/forwardTest?username=hfm&password=17111711">SpringMVC 提供的请求转发关键字 forward 的使用</a><br/>
<a href="response/redirectTest?username=hfm&password=17111711">SpringMVC 提供的请求转发关键字 redirect 的使用</a><br/>

<button id="btn">@ ResponseBody 注解处理 Ajax 异步请求</button>
<br/>
<script>
    $("#btn").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/response/ajaxTest",
            contentType: "application/json;charset=UTF-8",
            data: '{"userId": 1,"username": "hfm","password": "17111711"}',
            dataType: "json",
            type: "post",
            success: function (data) {

            }
        })
    });
</script>

<button id="btn1">@ ResponseBody 注解处理 Ajax 异步请求 json 字符串转对象</button>
<br/>
<script>
    $("#btn1").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/response/jsonToObject",
            contentType: "application/json;charset=UTF-8",
            data: '{"userId": 1,"username": "hfm","password": "17111711"}',
            dataType: "json",
            type: "post",
            success: function (data) {
                alert(data.username)
            }
        })
    });
</script>

<button id="btn2">接收 Integer 数组</button>
<br/>
<script>
    var ins = [1, 2, 3];

    ins = JSON.stringify(ins);// 将对象序列化成JSON字符串
    $("#btn2").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/response/arrayInteger",
            contentType: "application/json;charset=UTF-8",
            data: ins,
            dataType: "json",
            type: "post",
            success: function (data) {

            }
        })
    });
</script>

<button id="btn3">接收 List&lt;Integer&gt;</button>
<br/>
<script>
    var ins = new Array();
    ins.push(1);
    ins.push(2);
    ins.push(3);

    ins = JSON.stringify(ins);
    $("#btn3").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/response/listInteger",
            contentType: "application/json;charset=UTF-8",
            data: ins,
            dataType: "json",
            type: "post",
            success: function (data) {

            }
        })
    });
</script>

<button id="btn4">接收 String 数组</button>
<br/>
<script>
    var strings = ["hfm", "pdd", "tff"];

    var s = JSON.stringify(strings);
    $("#btn4").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/response/arrayString",
            contentType: "application/json;charset=UTF-8",
            data: s,
            dataType: "json",
            type: "post",
            success: function (data) {

            }
        })
    });
</script>

<button id="btn5">接收 List&lt;String&gt;</button>
<br/>
<script>
    var stringList = new Array();
    stringList.push("hfm");
    stringList.push("pdd");
    stringList.push("tty");

    var st = JSON.stringify(stringList);

    $("#btn5").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/response/listString",
            contentType: "application/json;charset=UTF-8",
            data: st,
            dataType: "json",
            type: "post",
            success: function (data) {

            }
        })
    });
</script>

<button id="btn6">接收 Object 数组</button>
<br/>
<script>
    <%--    定义 js 对象--%>
    var user = function (userId, username, password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    //创建 Js 对象
    var user1 = new user(1, "hfm", "17111711");
    var user2 = new user(2, "pdd", "154532");
    var user3 = new user(3, "trr", "6764533");

    // 创建数组
    var users = [user1, user2, user3];

    // 转化为 json
    users = JSON.stringify(users);
    $("#btn6").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/response/arrayObject",
            contentType: "application/json;charset=UTF-8",
            data: users,
            dataType: "json",
            type: "post",
            success: function (data) {

            }
        })
    });
</script>

<button id="btn7">接收 List&lt;Object&gt;</button>
<br/>
<script>
    <%--    定义 js 对象--%>
    var user = function (userId, username, password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    //创建 Js 对象
    var user1 = new user(1, "hfm", "17111711");
    var user2 = new user(2, "pdd", "154532");
    var user3 = new user(3, "trr", "6764533");

    // 创建集合
    var userList = new Array();

    userList.push(user1);
    userList.push(user2);
    userList.push(user3);

    // 转化为 json
    userList = JSON.stringify(userList);
    $("#btn7").click(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/response/listObject",
            contentType: "application/json;charset=UTF-8",
            data: userList,
            dataType: "json",
            type: "post",
            success: function (data) {

            }
        })
    });
</script>

<button id="btn8">接收 Map&lt;String,Object&gt;</button>
<br/>
<script>
    <%--    定义 js 对象--%>
    var user = function (userId, username, password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    //创建 Js 对象
    var user1 = new user(1, "hfm", "17111711");
    var user2 = new user(2, "pdd", "154532");
    var user3 = new user(3, "trr", "6764533");

    // 创建集合
    var map = new Map();
    map.set("user", user1);
    map.set("user", user2);
    map.set("user", user3);

    // 转化为 json
    mapString = JSON.stringify(map);
    $("#btn8").click(function () {
        alert(mapString)
        $.ajax({
            url: "${pageContext.request.contextPath}/response/mapObject",
            contentType: "application/json;charset=UTF-8",
            data: mapString,
            dataType: "json",
            type: "post",
            success: function (data) {

            }
        })
    });
</script>

</body>
</html>
