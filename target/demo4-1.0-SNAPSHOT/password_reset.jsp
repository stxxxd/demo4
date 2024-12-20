<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2024/12/13
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            margin:0 auto;
            width: 600px;
            height: 600px;
            padding-top: 20px;
        }
        h1{
            text-align: center;
        }
        #pwdresetFrom{
            margin-top: 50px;
            margin-left: 80px;
        }
        body{
            background-image: url("img/img.png") ;
        }
    </style>
</head>
<body>
<div>
<h1>密码重置</h1>
<form action="PasswordResetServlet" method="post" id="pwdresetFrom">
    用户名: <input type="text" name="username" ><br>
    安全问题答案: <input type="text" name="security_answer" ><br>
    新密码: <input type="password" name="new_password" ><br>
    <input type="submit" value="重置密码">
</form>
    <a href="LoginServlet">返回</a>
</div>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg!= null) {
%>
<div><%=msg%></div>
<%
    }
%>
</body>
</html>