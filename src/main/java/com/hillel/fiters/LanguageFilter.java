package com.hillel.fiters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

@WebFilter("*")
public class LanguageFilter implements Filter {
    public static final String DEFAULT_LOCALE = "en";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        String language = (String) session.getAttribute("language");

        if (language == null) {
            session.setAttribute("locale", DEFAULT_LOCALE);
            Config.set(session, "javax.servlet.jsp.jstl.fmt.language", DEFAULT_LOCALE);
        }

        chain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
