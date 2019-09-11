package com.hillel.api;

import com.hillel.entity.User;
import com.hillel.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = userService.findUser(name, password);

        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/");
        } else {
            request
                    .getRequestDispatcher("/login.jsp")
                    .forward(request, response);
        }
    }
}
