package controller.managers;

import entity.Time;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manager/save.do")
public class Save extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserService.getInstance().save(new User().setName(req.getParameter("name")).setFamily(req.getParameter("family"))
                    .setUsername(req.getParameter("username")).setPassword(req.getParameter("password")).setRole(req.getParameter("role")));
            UserService.getInstance().saveTime(new User().setUsername(req.getParameter("username")),new Time().setId(Long.parseLong(req.getParameter("id"))).setLogin(req.getSession().getCreationTime()).setLogout(req.getSession().getLastAccessedTime()));
            resp.sendRedirect("/manager/findAll.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
