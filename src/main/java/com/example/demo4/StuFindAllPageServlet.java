package com.example.demo4;

import Service.UserService;
import Service.UserServiceImpl;
import entity.Stu;
import entity.User;
import entity.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StuFindAllPageServlet", value = "/StuFindAllPageServlet")
public class StuFindAllPageServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageInfo = request.getParameter("pageNow");
        if (pageInfo == null) {
            pageInfo = "1";
        }
        int pageNow = Integer.parseInt(pageInfo);
        int pageCount = 5;
        int totolRows = userService.getTotalUserCount();
        int totalPages = (totolRows % pageCount == 0) ? (totolRows / pageCount) : (totolRows / pageCount + 1);
        if (pageNow < 1) {
            pageNow = 1;
        }
        if (pageNow > totalPages) {
            pageNow = totalPages;
        }
        page page = new page(pageNow, pageCount, totalPages, totolRows);
        List<Stu> stus = userService.findAllSTUPageable(pageNow, pageCount);
        request.setAttribute("stus", stus);
        request.setAttribute("page", page);
        request.getRequestDispatcher("stu.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
