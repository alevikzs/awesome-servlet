package org.awesome.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/some-filter"})
public class AwesomeSomeFilter extends Controller {

    protected void doPost(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();

        out.println("Awesome other filter!");
    }

}