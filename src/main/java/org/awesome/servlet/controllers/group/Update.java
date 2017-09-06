package org.awesome.servlet.controllers.group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.awesome.servlet.models.Group;

@WebServlet("/group/update")
public class Update extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        try {
            Group group = (Group) new Group().load(id);

            request.setAttribute("group", group);

            request.getRequestDispatcher("/WEB-INF/group/update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        try {
            Group group = (Group) new Group().load(id);

            group.setName(name).setDescription(description).save();

            response.sendRedirect(request.getContextPath() + "/groups");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}