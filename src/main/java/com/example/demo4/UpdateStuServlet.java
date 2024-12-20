package com.example.demo4;

import Service.UserService;
import Service.UserServiceImpl;
import entity.Stu;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateStuServlet", value = "/UpdateStuServlet")
public class UpdateStuServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        int sno = Integer.parseInt(request.getParameter("sno"));
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String born=request.getParameter("born");
        String professional=request.getParameter("professional");
        String classment=request.getParameter("classment");
        Stu stu=new Stu(id,sno,name,sex,born,professional,classment);
        userService.updateStu(stu);
        response.sendRedirect("StuFindAllPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
