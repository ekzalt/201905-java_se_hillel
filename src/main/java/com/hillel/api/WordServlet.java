package com.hillel.api;

import com.hillel.services.TextService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/word")
public class WordServlet extends HttpServlet {
    // constants
    public static final String CHARSET = "UTF-8";
    // services
    private final TextService textService = new TextService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = 0;
        String requestWord = request.getParameter("word");

        if (requestWord != null) {
            List<String> words = textService.splitTextToWords(textService.TEXT);
            Map<String, Integer> repetitions = textService.countRepetitions(words);
            count = repetitions.getOrDefault(requestWord, 0);
        }

        response.setCharacterEncoding(CHARSET);
        response.setContentType("text/plain");
        PrintWriter pw = response.getWriter();
        pw.println(requestWord + "=" + count);
        pw.close();
    }
}
