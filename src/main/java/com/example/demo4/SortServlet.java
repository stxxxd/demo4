package com.example.demo4;

import Service.UserService;
import Service.UserServiceImpl;
import entity.Stu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "SortServlet", value = "/SortServlet")
public class SortServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortField = request.getParameter("sortField");
        List<Stu> stus = userService.getStudentsSortedBy(sortField);
        request.setAttribute("stus", stus);
        request.getRequestDispatcher("stulist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }
}
