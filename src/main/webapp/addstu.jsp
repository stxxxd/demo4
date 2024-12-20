<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2024/12/15
  Time: 16:39
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
    #addForm{
    text-align: center;
    margin-top: 50px;
    margin-left:50px ;
    }
    body{
        background-image: url("img/img.png") ;
    }
    </style>
</head>
<body>
<div>
<h1>新增学生</h1>
<form action="StuAddServlet" method="post" id="addForm">
    输入id：<input type="text" name="id" ><br>
    输入学号：<input type="text" name="sno" ><br>
    输入姓名: <input type="text" name="name" ><br>
    输入性别: <input type="text" name="sex" ><br>
    输入出生日期: <input type="text" name="born" ><br>
    输入专业: <input type="text" name="professional" ><br>
    输入班级: <input type="text" name="classment" ><br>
    <input type="submit" value="新增">
</form>
</div>
</body>
</html>
