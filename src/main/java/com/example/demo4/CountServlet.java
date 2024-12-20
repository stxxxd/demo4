package com.example.demo4;

import Service.UserService;
import Service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CountServlet", value = "/CountServlet")
public class CountServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int stuCount = userService.getStuCount();
        Map<String, Integer> sexRatio = userService.getSexRatio();
        Map<String, Integer> professionalCount= userService.getProfessionalCount();
        request.setAttribute("stuCount", stuCount);
        request.setAttribute("sexRatio", sexRatio);
        request.setAttribute("professionalCount", professionalCount);
        request.getRequestDispatcher("statistics.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
