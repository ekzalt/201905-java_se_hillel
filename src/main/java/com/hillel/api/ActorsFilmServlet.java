package com.hillel.api;

import com.hillel.entity.Actor;
import com.hillel.entity.Film;
import com.hillel.services.VideoLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/actors/film")
public class ActorsFilmServlet extends HttpServlet {
    public static final String CHARSET = "UTF-8";

    private final VideoLibrary videoLibrary = new VideoLibrary();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/actors/film-get.jsp")
                .forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Actor> actors = new ArrayList<>();
        String requestName = request.getParameter("name");

        if (requestName != null) {
            actors = videoLibrary.findActorsByFilmName(requestName);
        }

        /*
        response.setCharacterEncoding(CHARSET);
        response.setContentType("text/plain");
        PrintWriter pw = response.getWriter();
        pw.println(actors);
        pw.close();
        */

        request.setAttribute("actors", actors);
        request
                .getRequestDispatcher("/actors/response.jsp")
                .forward(request, response);
    }
}
