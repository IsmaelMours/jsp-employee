package com.example.employee.servlets;

import com.example.employee.model.Employee;
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
import java.util.ArrayList;
import java.util.List;

// ViewEmployeesServlet.java
@WebServlet("/viewEmployees")
public class ViewEmployeesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = DBConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM employees";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Employee> employees = new ArrayList<>();

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String position = resultSet.getString("position");

                        employees.add(new Employee(id, name, position));
                    }

                    // Set the list of employees as an attribute in the request
                    request.setAttribute("employees", employees);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving employees");
            return;
        }

        // Forward to viewEmployees.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewEmployees.jsp");
        dispatcher.forward(request, response);
    }
}

