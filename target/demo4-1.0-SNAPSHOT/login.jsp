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
            padding-top: 80px;
        }
        h1{
            text-align: center;
        }
        #loginForm{
            text-align: center;
            margin-top: 80px;
        }
        button{
            margin-right: 10px;
        }
        body{
            background-image: url("img/img.png") ;
        }
        #zc{
            margin-left: 10px;
        }
        #zt,#z{
            font-size: 20px;
        }
    </style>
</head>
<body>
<div>
<h1>用户登录</h1>
<form action="LoginServlet" method="post" id="loginForm">
    <span id="z">用户名:</span> <input type="text" name="username" id="uname"><br>
    <span id="zt">密码:</span>  <input type="password" name="password" id="upwd"><br>
    <span id="msg" style="font-size: 12px;color: #dc143c"></span><br>
    <button type="button" value="登录" id="loginbtn">登录</button>
    <a href="password_reset.jsp">找回密码</a><a href="register.jsp" id="zc">注册</a>
</form>
</div>
<script type="text/javascript" src="js/jquery-3.7.1.js"></script>
<script type="text/javascript">
    $("#loginbtn").click(function (){
        var uname=$("#uname").val();
        var upwd=$("#upwd").val();
        if(isEmpty(uname)){
            $("#msg").html("用户名不可为空！");
            return;
        }
        if(isEmpty(upwd)){
            $("#msg").html("密码不可为空！");
            return;
        }
        $("#loginForm").submit();
    });
    function isEmpty(str){
        if(str==null||str.trim()==""){
           return  true;
        }
        return false;
    }
</script>
</body>
</html>
