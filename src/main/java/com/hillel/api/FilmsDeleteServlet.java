package com.hillel.api;

import com.hillel.services.VideoLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/films/delete")
public class FilmsDeleteServlet extends HttpServlet {
    public static final String CHARSET = "UTF-8";

    private final VideoLibrary videoLibrary = new VideoLibrary();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/films/delete-get.jsp")
                .forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int year = 0;

        try {
            year = Integer.parseInt(request.getParameter("year"));

            if (year != 0) {
                // videoLibrary.deleteFilmsOlderThan(year);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        response.setCharacterEncoding(CHARSET);
        response.setContentType("text/plain");
        PrintWriter pw = response.getWriter();
        pw.println("deleted all films older than " + year);
        pw.close();
    }
}
