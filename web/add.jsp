<%--
  Created by IntelliJ IDEA.
  User: WaHotDog
  Date: 2019/6/20
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <%-- 网页使用的语言 --%>
    <meta charset="UTF-8">
    <%-- 使用Edge最新的浏览器的渲染方式 --%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加联系人</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
       function  submitUser(){
           var pd = 0;
           var user = document.getElementById("Uname").value;
           var age = document.getElementById("age").value;
           var qq = document.getElementById("QQ").value;
           var email = document.getElementById("Email").value;
           if(user.length>0){pd=pd+1}
           if(age.length>0){pd=pd+1}
           if(qq.length>0){pd=pd+1}
           if(email.length>0){pd=pd+1}
           if(pd==4){
               var form = document.getElementById('addUser');
               form.submit();
           }else{
               alert("信息填写不完整，提交失败！")
           }
       }
    </script>
</head>
<body>
    <div class="container">
        <h2 style="text-align: center"> 添加联系人页面 </h2>
        <form action="${pageContext.request.contextPath}/addUserServlet" method="post" id="addUser">
            <div class="form-group">
                <label for="Uname">姓名</label>
                <input type="text" class="form-control" id="Uname" name="name" placeholder="请输入姓名">
            </div>
            <div class="form-group">
                <label >性别</label>
                <input type="radio" name="gender" value="男" checked="checked">男
                <input type="radio" name="gender" value="女">女
            </div>
            <div class="form-group">
                <label for="age">年龄</label>
                <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
            </div>
            <div class="form-group">
                <label for="address">籍贯</label>
                <select name="address" class="form-control" id="address">
                    <option value="上虞-东关" selected="selected">上虞-东关"</option>
                    <option value="绍兴-越城区">绍兴-越城区</option>
                    <option value="其他区域">其他区域</option>
                </select>
            </div>
            <div class="form-group">
                <label for="QQ">QQ</label>
                <input type="text" class="form-control" id="QQ" name="qq" placeholder="请输入QQ号码">
            </div>
            <div class="form-group">
                <label for="Email">Email</label>
                <input type="text" class="form-control" id="Email" name="email" placeholder="请输入邮箱地址">
            </div>
            <div class="form-group" style="text-align: center">
                <a href="javascript:submitUser();"><input class="btn btn-primary" type="button" value="提交" /></a>
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/findUserByPageServlet'" />
            </div>
        </form>
    </div>
</body>
</html>
