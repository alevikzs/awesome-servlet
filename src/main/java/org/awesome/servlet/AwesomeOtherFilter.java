package org.awesome.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/other-filter"})
public class AwesomeOtherFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();

        out.println("Awesome other filter!");
    }

    public void destroy() {

    }

}