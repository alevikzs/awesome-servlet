package org.awesome.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/other-filter"})
public class AwesomeOtherFilter extends Controller {

    protected void doGet(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();

        out.println("Awesome other filter!");
    }

}