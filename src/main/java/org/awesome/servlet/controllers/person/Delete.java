package org.awesome.servlet.controllers.person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.awesome.servlet.models.Person;

@WebServlet("/person/delete")
public class Delete extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        try {
            Person person = (Person) new Person().load(id);

            person.delete();

            response.sendRedirect(request.getContextPath() + "/persons");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}