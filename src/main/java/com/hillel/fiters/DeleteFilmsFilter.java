package com.hillel.fiters;

import com.hillel.entity.Role;
import com.hillel.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/films/delete")
public class DeleteFilmsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpRequest.getMethod().equals("POST")) {
            HttpSession session = httpRequest.getSession();
            User user = (User) session.getAttribute("user");

            if (user != null && user.getRole() == Role.ADMIN) {
                chain.doFilter(httpRequest, httpResponse);
            } else {
                httpResponse.sendRedirect("/login");
            }
        } else {
            chain.doFilter(httpRequest, httpResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
