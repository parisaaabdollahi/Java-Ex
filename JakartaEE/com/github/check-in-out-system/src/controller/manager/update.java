package controller.manager;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manager/update.do")
public class update extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserService.getInstance().update(new User().setId(Long.parseLong(req.getParameter("id"))).setName(req.getParameter("name")).setFamily(req.getParameter("family"))
                    .setUsername(req.getParameter("username")).setPassword(req.getParameter("password")).setRole(req.getParameter("role")));
            resp.sendRedirect("/manager/findAll.do");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
