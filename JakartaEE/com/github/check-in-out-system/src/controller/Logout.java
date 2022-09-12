package controller;

import entity.Time;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/manager/logout.do")
public class Logout extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            req.getSession().invalidate();
            resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
