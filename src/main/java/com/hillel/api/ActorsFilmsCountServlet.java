package com.hillel.api;

import com.hillel.entity.Actor;
import com.hillel.services.VideoLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/actors/films-count")
public class ActorsFilmsCountServlet extends HttpServlet {
    public static final String CHARSET = "UTF-8";

    private final VideoLibrary videoLibrary = new VideoLibrary();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/actors/films-count-get.jsp")
                .forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Actor> actors = new ArrayList<>();
        int count = 0;

        try {
            count = Integer.parseInt(request.getParameter("count"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (count != 0) {
            actors = videoLibrary.findActorsWhoHasFilmsCount(count);
        }

        request.setAttribute("actors", actors);
        request
                .getRequestDispatcher("/actors/response.jsp")
                .forward(request, response);
    }
}
