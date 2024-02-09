<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>View Employees</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<h2>Employees List</h2>

<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Position</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="employee" items="${employees}">
    <tr>
      <td>${employee.id}</td>
      <td>${employee.name}</td>
      <td>${employee.position}</td>
      <td>
        <a href="${pageContext.request.contextPath}/updateEmployee?id=${employee.id}">Update</a>
        <a href="${pageContext.request.contextPath}/deleteEmployee?id=${employee.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<br>
<a href="${pageContext.request.contextPath}/addEmployee">Add New Employee</a>

</body>
</html>
