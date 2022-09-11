package controller.manager;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class findTime extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("listTime", UserService.getInstance().findTime());
            req.getRequestDispatcher("").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
