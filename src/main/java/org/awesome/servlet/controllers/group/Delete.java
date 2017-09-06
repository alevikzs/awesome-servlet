package org.awesome.servlet.controllers.group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.awesome.servlet.models.Group;

@WebServlet("/group/delete")
public class Delete extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        try {
            Group group = (Group) new Group().load(id);

            group.delete();

            response.sendRedirect(request.getContextPath() + "/groups");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}