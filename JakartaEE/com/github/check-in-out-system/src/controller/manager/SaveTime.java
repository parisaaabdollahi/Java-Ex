package controller.manager;

import entity.Time;
import entity.User;
import service.UserService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("manager/save.do")
public class SaveTime extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User().setUsername(req.getParameter("username"));
        Time time=new Time().setId(Long.parseLong(req.getParameter("id"))).setLogin(req.getSession().getCreationTime()).setLogout(req.getSession().getLastAccessedTime());
        try {
            UserService.getInstance().saveTime(user,time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
