package org.awesome.servlet.controllers.person;

import org.awesome.servlet.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/person")
public class Create extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/person/create.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Statement statement = new DbConnection().getStatement();

        try {
            String sql = "INSERT INTO persons (firstName, lastName) VALUES('" + firstName + "', '" + lastName + "')";

            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }


        PrintWriter out = response.getWriter();
        out.println("First Name: " + firstName);
        out.println("Last Name: " + lastName);
    }

}