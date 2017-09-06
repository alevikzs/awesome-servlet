package org.awesome.servlet.controllers.person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.awesome.servlet.models.Person;

@WebServlet("/person/update")
public class Update extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        try {
            Person person = (Person) new Person().load(id);

            request.setAttribute("person", person);

            request.getRequestDispatcher("/WEB-INF/person/update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        try {
            Person group = (Person) new Person().load(id);

            group.setFirstName(firstName).setLastName(lastName).save();

            response.sendRedirect(request.getContextPath() + "/persons");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}