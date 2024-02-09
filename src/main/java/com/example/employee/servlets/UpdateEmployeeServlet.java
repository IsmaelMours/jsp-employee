package com.example.employee.servlets;

import com.example.employee.util.DBConnectionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// UpdateEmployeeServlet.java
@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String name = request.getParameter("name");
        String position = request.getParameter("position");

        try (Connection connection = DBConnectionUtil.getConnection()) {
            String sql = "UPDATE employees SET name = ?, position = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, position);
                preparedStatement.setInt(3, employeeId);
                preparedStatement.executeUpdate();
            }

            // Redirect to viewEmployees.jsp after updating
            response.sendRedirect(request.getContextPath() + "/viewEmployees");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating employee");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests if needed
        response.sendRedirect(request.getContextPath() + "/updateEmployee.jsp");
    }
}
