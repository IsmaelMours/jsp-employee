package com.example.employee.servlets;

// AddEmployeeServlet.java
import com.example.employee.util.DBConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String position = request.getParameter("position");

        try (Connection connection = DBConnectionUtil.getConnection()) {
            String sql = "INSERT INTO employees (name, position) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, position);
                preparedStatement.executeUpdate();
            }

            // Redirect to viewEmployees.jsp after adding
            response.sendRedirect(request.getContextPath() + "/viewEmployees");
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding employee");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests if needed
        response.sendRedirect(request.getContextPath() + "/addEmployee.jsp");
    }
}
