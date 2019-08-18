package com.hillel;

import com.hillel.hw14.text.TextService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/two")
public class TwoServlet extends HttpServlet {
    // services
    private final TextService textService = new TextService();
    // constants
    public static final String CHARSET = "UTF-8";

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
