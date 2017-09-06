package org.awesome.servlet.controllers.person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.awesome.servlet.Models;
import org.awesome.servlet.models.Person;

@WebServlet("/persons")
public class Index extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Models persons = new Person().findAll();

            request.setAttribute("persons", persons);

            request.getRequestDispatcher("/WEB-INF/person/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}