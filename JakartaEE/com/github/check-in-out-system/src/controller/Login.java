package controller;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User().setEmployeeCode(req.getParameter("employeeCode")).setPassword(req.getParameter("password"));
        try {
            UserService.getInstance().login(user);
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("/"+user.getRole());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("khata");
        }
    }
}
