package controller;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save.do")
public class Save extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserService.getInstance().save(new User().setName(req.getParameter("name")).setFamily(req.getParameter("family"))
                    .setUsername(req.getParameter("username")).setPassword(req.getParameter("password")).setRole(req.getParameter("role")));
            resp.sendRedirect("/findAll.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
