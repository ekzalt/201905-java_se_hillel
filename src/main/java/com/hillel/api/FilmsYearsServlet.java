package com.hillel.api;

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

@WebServlet("/films/years")
public class FilmsYearsServlet extends HttpServlet {
    public static final String CHARSET = "UTF-8";

    private final VideoLibrary videoLibrary = new VideoLibrary();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/films/years-get.jsp")
                .forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Film> films = new ArrayList<>();
        int from = 0;
        int to = 0;

        try {
            from = Integer.parseInt(request.getParameter("from"));
            to = Integer.parseInt(request.getParameter("to"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (from != 0 && to != 0) {
            films = videoLibrary.findFilmsBetweenYears(from, to);
        }

        request.setAttribute("films", films);
        request
                .getRequestDispatcher("/films/response.jsp")
                .forward(request, response);

    }
}
