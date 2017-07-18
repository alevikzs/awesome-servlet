package org.awesome.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AwesomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("Awesome testing!!!");
    }

}