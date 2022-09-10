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
        User user = new User().setUsername(req.getParameter("username")).setPassword(req.getParameter("password")).setName(req.getParameter("name")).setFamily(req.getParameter("family")).setRole(req.getParameter("role"));
        try {
            UserService.getInstance().login(user);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/" + user.getRole());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("KHATA");
        }
    }
}
