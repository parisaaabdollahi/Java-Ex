package controller;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class remove extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserService.getInstance().remove(new User().setUsername(req.getParameter("username")));
            resp.sendRedirect("/findAll.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
