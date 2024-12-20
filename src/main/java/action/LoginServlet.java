package action;

import Service.UserService;
import Service.UserServiceImpl;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> users = userService.getUserByUsername(username);
        if (users == null || users.isEmpty() ||!users.get(0).getPassword().equals(password)) {
            request.setAttribute("msg", "用户名或密码错误，请重试！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", users.get(0).getRole());
            response.sendRedirect("StuFindAllPageServlet");
        }
    }
}

