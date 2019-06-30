<%--
  Created by IntelliJ IDEA.
  User: WaHotDog
  Date: 2019/6/19
  Time: 7:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%-- 网页使用的语言 --%>
    <meta charset="UTF-8">
    <%-- 使用Edge最新的浏览器的渲染方式 --%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
  </head>
  <body>
  <div style="margin: 5px">
    ${user.name},欢迎您。
  </div>
  <div align="center">
    <a href=" ${pageContext.request.contextPath}/findUserByPageServlet" style="font-size: 33px;text-decoration: none">查询所有用户信息</a>
  </div>
  <div>
    ${ccc}
  </div>
  </body>
</html>
