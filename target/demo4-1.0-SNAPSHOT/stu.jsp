<%@ page import="entity.Stu" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.page" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2024/12/15
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style>
        h1{
            text-align: center;
        }
        #add,#sc,#jl,#px{
            margin-left: 200px;
        }
        body{
            background-image: url("img/img.png") ;
        }
    </style>
</head>
<body>
<%
    List<Stu>stus= (ArrayList)(request.getAttribute("stus"));
    page p = (page)(request.getAttribute("page"));
%>
<h1>学生信息管理</h1>
<a href="addstu.jsp" id="add">添加学生</a>
<form action="SearchStuServlet" method="get" id="sc">
    关键字：<input type="text" name="id"><br>
    <input type="submit" value="搜索">
</form>
<table border="1" style="text-align: center;margin-left: 200px">
        <tr>
            <td>id</td><td><a href="CountServlet?action=sort&sortField=sno">学号</a></td><td>姓名</td>
            <td><a href="CountServlet?action=sort&sortField=sex>">性别</a></td><td>出生日期</td><td><a href="CountServlet?action=sort&sortField=professional">专业</a></td><td>班级</td><td>操作</td>
        </tr>
    <%
        for(int i = 0;i<stus.size(); i++){
            Stu stu =stus.get(i);
    %>
        <tr>
            <td><%=stu.getId()%></td>
            <td><%=stu.getSno()%></td>
            <td><%=stu.getName()%></td>
            <td><%=stu.getSex()%></td>
            <td><%=stu.getBorn()%></td>
            <td><%=stu.getProfessional()%></td>
            <td><%=stu.getClassment()%></td>
            <td><a href="SearchStuServlet?id=<%=stu.getId()%>">修改</a>
                <a href="javascript:deleteUser(<%=stu.getId()%>)">删除</a></td>
        </tr>
    <%
        }
    %>
</table>
<a href="SortServlet" id="px">排序</a>
<div id="jl">共<%=p.getTotalRows()%>条记录，<%=p.getPageNow()%>/<%=p.getTotalPage()%>
<a href="StuFindAllPageServlet?pageNow=<%=p.getPageNow()-1%>" >上一页</a>
<a href="StuFindAllPageServlet?pageNow=<%=p.getPageNow()+1%>">下一页</a>
</div>
<script>
    function deleteUser(id){
        if(confirm("确定要删除吗？")){
            location.href="deleteStuServlet?id="+id;
        }
    }
</script>
</body>
</html>
