<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/7/2024
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="controller-servlet" method="post">
        <input type="hidden" name="action" value="login">
        <input type="text" name="account_id" placeholder="Username">
        <input type="password" name="password" placeholder="Password">
        <input type="submit" value="Login">
    </form>
    <script>
        <% if (request.getAttribute("error") != null) { %>
        alert("Invalid username or password");
        <% } %>
    </script>

</body>
</html>
