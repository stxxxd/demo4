<%@ page import="entity.Stu" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2024/12/17
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
        background-image: url("img/img.png") ;
    }
    </style>
</head>
<body>
<%
    Stu stu=(Stu) (request.getAttribute("stu"));
%>
<h2>更新用户</h2>
<form action="UpdateStuServlet" method="post">
    <%
        if (stu!= null) {
    %>
    <input type="hidden" name="id" value="<%=stu.getId()%>"><br>
    <%
        }
    %>
    输入学号：<input type="text" name="sno" value="<%=stu.getSno()%>">
    输入姓名：<input type="text" name="name" value="<%=stu.getName()%>"><br>
    输入性别：<input type="text" name="sex" value="<%=stu.getSex()%>"><br>
    输入出生日期：<input type="text" name="born" value="<%=stu.getBorn()%>"><br>
    输入专业：<input type="text" name="professional" value="<%=stu.getProfessional()%>"><br>
    输入班级：<input type="text" name="classment" value="<%=stu.getClassment()%>"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
