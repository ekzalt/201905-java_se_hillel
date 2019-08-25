package com.hillel.api;

import com.hillel.entity.Actor;
import com.hillel.entity.Director;
import com.hillel.services.VideoLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/directors/name")
public class DirectorsServlet extends HttpServlet {
    public static final String CHARSET = "UTF-8";

    private final VideoLibrary videoLibrary = new VideoLibrary();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/directors/name-get.jsp")
                .forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Director> directors = new ArrayList<>();
        String requestName = request.getParameter("name");

        if (requestName != null) {
            Director director = videoLibrary.findDirectorByName(requestName);

            if (director != null) {
                directors.add(director);
            }
        }

        request.setAttribute("directors", directors);
        request
                .getRequestDispatcher("/directors/response.jsp")
                .forward(request, response);
    }
}
