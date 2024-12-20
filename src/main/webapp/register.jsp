<%@ page import="entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2024/12/13
  Time: 22:54
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
        #registerForm{
            margin-top: 80px;
            margin-left: 80px;
        }
        span{
            font-size: 20px;
        }
        body{
            background-image: url("img/img.png") ;
        }
    </style>
</head>
<body>
<div>
<h1>用户注册</h1>
<form action="RegisterServlet" method="post" id="registerForm">
    <span>用户名:</span> <input type="text" name="username" ><br>
    <span>密码:</span> <input type="password" name="password" ><br>
    <span>邮箱:</span>  <input type="email" name="email" ><br>
    <span>安全问题:</span> <input type="text" name="securityQuestion" ><br>
    <span>安全问题答案:</span> <input type="text" name="securityAnswer" ><br>
    <input type="submit" value="注册">
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
