<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>Update Employee</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<h2>Update Employee</h2>

<form action="${pageContext.request.contextPath}/updateEmployee" method="post">
  <!-- Hidden field for employee ID -->
  <input type="hidden" name="employeeId" value="${employeeId}">

  <label for="name">Name:</label>
  <input type="text" id="name" name="name" value="${name}" required><br>

  <label for="position">Position:</label>
  <input type="text" id="position" name="position" value="${position}" required><br>

  <input type="submit" value="Update Employee">
</form>

<br>
<a href="${pageContext.request.contextPath}/viewEmployees">View Employees</a>

</body>
</html>
