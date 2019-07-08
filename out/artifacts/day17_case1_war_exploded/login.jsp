<%--
  Created by IntelliJ IDEA.
  User: WaHotDog
  Date: 2019/6/20
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">

        //刷新验证码
        function refreshCode(){
            var img = document.getElementById("vcode");
            img.onclick=function () {
                <%--动态获取虚拟目录--%>
                img.src= "${pageContext.request.contextPath}/checkCodeServlet?"+new Date().getTime();
            }
        }
    </script>
</head>
<body>
    <%--${pageContext.request.setAttribute("msg","这边是提示框！")}--%>
    <div class="container" style="width: 400px">
        <form action="${pageContext.request.contextPath}/loginServlet" method="post">
            <h2 style="text-align: center">管理员登录</h2>
            <div class="form-group">
                <label for="user">用户名:</label>
                <input type="text" name="username" class="form-control" id="user" placeholder="请输入账号">
            </div>
            <div class="form-group">
                <label for="password">密码:</label>
                <input type="text" name="password" class="form-control" id="password" placeholder="请输入密码">
            </div>
            <div class="form-inline">
                <label for="vcodes">验证码：</label>
                <input type="text" name="verifycode" class="form-control" id="vcodes" placeholder="请输入验证码" style="width: 120px;"/>
                <a href="javascript:refreshCode();"><img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/></a>
            </div>
            <hr>
            <div class="form-group" style="text-align: center">
                <button type="submit" class="btn btn-primary btn-lg active">登录</button>
            </div>
        </form>
        <div class="alert alert-warning alert-dismissible" role="alert">
<%--            <button type="button" class="close" data-dismiss="alert" >--%>
<%--                <span>&times;</span>--%>
<%--            </button>--%>
            <button type="button" class="close" aria-label="Close" data-dismiss="alert"><span aria-hidden="true">&times;</span></button>
            <strong>${requestScope.msg}</strong>
        </div>
    </div>
</body>
</html>
