package com.example.demo4;

import Service.UserService;
import Service.UserServiceImpl;
import entity.Stu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StuAddServlet", value = "/StuAddServlet")
public class StuAddServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        int sno = Integer.parseInt(request.getParameter("sno"));
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String born=request.getParameter("born");
        String professional=request.getParameter("professional");
        String classment=request.getParameter("classment");
        Stu stu=new Stu(id,sno,name,sex,born,professional,classment);
        userService.addstu(stu);
        response.sendRedirect("StuFindAllPageServlet");
    }
}
