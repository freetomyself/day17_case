<%--
  Created by IntelliJ IDEA.
  User: WaHotDog
  Date: 2019/6/20
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改联系人</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function jump() {
            window.location.href = '${pageContext.request.contextPath}/findUserByPageServlet';
        }

        function submit() {
            var pd = 0;
            var age = document.getElementById("age").value;
            var qq = document.getElementById("QQ").value;
            var email = document.getElementById("Email").value;
            if (age.length > 0) {
                pd = pd + 1
            }
            if (qq.length > 0) {
                pd = pd + 1
            }
            if (email.length > 0) {
                pd = pd + 1
            }
            if (pd == 3) {
                var form = document.getElementById('updateUser');
                form.submit();
            } else {
                alert("信息填写不完整，提交失败！")
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h2 style="text-align: center"> 修改联系人 </h2>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post" id="updateUser">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="Uname">姓名</label>
            <input type="text" class="form-control" id="Uname" readonly="readonly" name ="name" value="${user.name}">
        </div>
        <div class="form-group">
            <label>性别</label>
            <c:if test="${user.gender == '男' or user.gender == 'male' }">
                <input type="radio" name="gender" value="男" checked="checked">男
                <input type="radio" name="gender" value="女">女
            </c:if>
            <c:if test="${user.gender == '女' or user.gender == 'female'}">
                <input type="radio" name="gender" value="男">男
                <input type="radio" name="gender" value="女" checked="checked">女
            </c:if>

        </div>
        <div class="form-group">
            <label for="age">年龄</label>
            <input type="text" class="form-control" id="age" name="age" value="${user.age}" placeholder="请输入年龄">
        </div>
        <div class="form-group">
            <label for="address">籍贯</label>
            <select name="address" class="form-control" id="address">
                <c:if test="${user.address != '上虞-东关' and user.address != '绍兴-越城区' and user.address != '其他区域'}">
                    <option value="上虞-东关" >上虞-东关"</option>
                    <option value="绍兴-越城区">绍兴-越城区</option>
                    <option value="其他区域" selected="selected">其他区域</option>
                </c:if>
                <c:if test="${user.address == '上虞-东关'}">
                    <option value="上虞-东关" selected="selected">上虞-东关"</option>
                    <option value="绍兴-越城区">绍兴-越城区</option>
                    <option value="其他区域">其他区域</option>
                </c:if>
                <c:if test="${user.address == '绍兴-越城区'}">
                    <option value="上虞-东关" >上虞-东关"</option>
                    <option value="绍兴-越城区" selected="selected">绍兴-越城区</option>
                    <option value="其他区域">其他区域</option>
                </c:if>
                <c:if test="${user.address == '其他区域'}">
                    <option value="上虞-东关" >上虞-东关"</option>
                    <option value="绍兴-越城区">绍兴-越城区</option>
                    <option value="其他区域" selected="selected">其他区域</option>
                </c:if>
            </select>
        </div>
        <div class="form-group">
            <label for="QQ">QQ</label>
            <input type="text" class="form-control" id="QQ" name="qq" value="${user.qq}" placeholder="请输入QQ号码">
        </div>
        <div class="form-group">
            <label for="Email">Email</label>
            <input type="text" class="form-control" id="Email" name="email" value="${user.email}" placeholder="请输入邮箱地址">
        </div>
        <div class="form-group" style="text-align: center">
            <a href="javascript:submit();"><input class="btn btn-primary" type="button" value="提交"/></a>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回" onclick="jump()"/>
        </div>
    </form>
</div>
</body>
</html>
