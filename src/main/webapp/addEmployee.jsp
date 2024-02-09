<!-- addEmployee.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<h2>Add Employee</h2>

<form action="${pageContext.request.contextPath}/addEmployee" method="post">
    Name: <input type="text" name="name" required><br>
    Position: <input type="text" name="position" required><br>
    <input type="submit" value="Add Employee">
</form>

</body>
</html>
