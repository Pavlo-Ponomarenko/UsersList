package org.users.list.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccessFilter implements Filter {

    private List<String> primaryUrls = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        primaryUrls.add("new_profile");
        primaryUrls.add("add_profile");
        primaryUrls.add("login");
        primaryUrls.add("verify");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        StringBuffer requestURL = req.getRequestURL();
        String[] urls = requestURL.toString().split("/");
        String url = urls[urls.length - 1];
        boolean isAuthorizing = primaryUrls.contains(url) || requestURL.indexOf(".js") != -1;
        if (!isAuthorizing && req.getSession().getAttribute("login") == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login");
            requestDispatcher.forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
