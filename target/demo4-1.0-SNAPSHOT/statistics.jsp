<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生统计数据</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("img/img.png") ;

        }

        table {
            border-collapse: collapse;
            width: 50%;
            margin: 20px auto;
        }

        table td, table th {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
<h2>学生统计信息</h2>
<p>学生总数：${stuCount}</p>
<h3>性别比例</h3>
<table>
    <tr>
        <th>性别</th>
        <th>人数</th>
    </tr>
    <c:forEach items="${sexRatio}" var="sex">
        <tr>
            <td>${sex.key}</td>
            <td>${sex.value}</td>
        </tr>
    </c:forEach>
</table>
<h3>各专业人数统计</h3>
<table>
    <tr>
        <th>专业</th>
        <th>人数</th>
    </tr>
    <c:forEach items="${professionalCount}" var="professional">
        <tr>
            <td>${professional.key}</td>
            <td>${professional.value}</td>
        </tr>
    </c:forEach>
</table>
<a href="StuFindAllPageServlet">返回</a>
</body>
</html>