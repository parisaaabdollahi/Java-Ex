package controller;

import entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
User user=(User) request.getSession().getAttribute("user");
if (user==null)
response.sendRedirect("/index.jsp");

else {
    if(request.getRequestURI().split("/")[1].equals(user.getRole()))
filterChain.doFilter(servletRequest,servletResponse);
else response.sendRedirect("/index.jsp");
}
    }

    @Override
    public void destroy() {

    }
}
