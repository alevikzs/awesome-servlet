package org.awesome.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

public class Controller implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    final public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
            this.doPost(request, response);
        } else if (httpRequest.getMethod().equalsIgnoreCase("GET")) {
            this.doGet(request, response);
        } else if (httpRequest.getMethod().equalsIgnoreCase("PUT")) {
            this.doPut(request, response);
        } else if (httpRequest.getMethod().equalsIgnoreCase("DELETE")) {
            this.doDelete(request, response);
        }

        chain.doFilter(request, response);
    }

    public void destroy() {

    }

    protected void doGet(ServletRequest request, ServletResponse response) {
        throw new HTTPException(404);
    }

    protected void doPost(ServletRequest request, ServletResponse response) {
        throw new HTTPException(404);
    }

    protected void doPut(ServletRequest request, ServletResponse response) {
        throw new HTTPException(404);
    }

    protected void doDelete(ServletRequest request, ServletResponse response) {
        throw new HTTPException(404);
    }

}
