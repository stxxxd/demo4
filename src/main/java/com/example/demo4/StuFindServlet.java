package com.example.demo4;

import Service.UserService;
import Service.UserServiceImpl;
import entity.Stu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StuFindServlet", value = "/StuFindServlet")
public class StuFindServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Stu> stus = userService.findAllStus();
        request.setAttribute("stus", stus);
        request.getRequestDispatcher("stu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
