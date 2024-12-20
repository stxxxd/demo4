package action;

import Service.UserService;
import Service.UserServiceImpl;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PasswordResetServlet", value = "/PasswordResetServlet")
public class PasswordResetServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("password_reset.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String securityAnswer = request.getParameter("securityAnswer");
        String newPassword = request.getParameter("new_password");
       userService.verifyUserBySecurityAnswer(username,securityAnswer);
       try{
            userService.updatePassword(username,newPassword);
            try {
                request.setAttribute("msg", "密码重置成功，请重新登录！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }catch(Exception e){
                e.printStackTrace();
                request.setAttribute("msg", "密码重置失败，请重试！");
                request.getRequestDispatcher("password_reset.jsp").forward(request, response);
            }
        }catch(Exception e){
           e.printStackTrace();
           request.setAttribute("msg", "安全问题答案错误，无法重置密码！");
           response.sendRedirect("login.jsp");
        }
    }

}

