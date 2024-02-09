<!-- deleteEmployee.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>Delete Employee</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<h2>Delete Employee</h2>

<form action="${pageContext.request.contextPath}/deleteEmployee" method="get">
  ID: <input type="text" name="id" readonly value="${employee.id}">
  Name: ${employee.name}<br>
  Position: ${employee.position}<br>
  <input type="submit" value="Delete Employee">
</form>

</body>
</html>

