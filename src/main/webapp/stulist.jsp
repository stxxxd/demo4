<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息列表</title>
    <style>
        body{
            background-image: url("img/img.png") ;
        }
    </style>
</head>
<body>
<h2>学生信息列表</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>专业</th>
        <th>班级</th>
    </tr>
    <c:forEach items="${stus}" var="stu">
        <tr>
            <td>${stu.getId()}</td>
            <td>${stu.getSno()}</td>
            <td>${stu.getName()}</td>
            <td>${stu.getSex()}</td>
            <td>${stu.getBorn()}</td>
            <td>${stu.getProfessional()}</td>
            <td>${stu.getClassment()}</td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value='/SortServlet?action=sort&sortField=sno'/>">按学号排序</a>
<a href="<c:url value='/SortServlet?action=sort&sortField=name'/>">按姓名排序</a>
<a href="<c:url value='/SortServlet?action=sort&sortField=classment'/>">按班级排序</a><br>
<a href="StuFindAllPageServlet">返回</a>
</body>
</html>