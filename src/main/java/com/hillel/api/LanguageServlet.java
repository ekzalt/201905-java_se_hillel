package com.hillel.api;

import com.hillel.entity.User;
import com.hillel.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/language")
public class LanguageServlet extends HttpServlet {
    private UserService userService = new UserService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter("language");

        if (language != null) {
            request.getSession().setAttribute("language", language);
        }

        response.sendRedirect("/");
    }
}
