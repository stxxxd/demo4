package com.example.demo4;

import Service.UserService;
import Service.UserServiceImpl;
import entity.Stu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchStuServlet", value = "/SearchStuServlet")
public class SearchStuServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Stu stu = userService.searchStu(id);
        request.setAttribute("stu", stu);
        request.getRequestDispatcher("updateStu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
